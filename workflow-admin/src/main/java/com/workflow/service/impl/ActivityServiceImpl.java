package com.workflow.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.workflow.common.api.StringUtils;
import com.workflow.common.enumerate.*;
import com.workflow.common.uuid.SnowflakeIdGenerator;
import com.workflow.common.uuid.OnlyCode;
import com.workflow.exception.ActivityException;
import com.workflow.mapper.*;
import com.workflow.model.*;
import com.workflow.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 工作流处理service
 * Create by wl on 2020/7/16
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActDeploymentMapper deploymentMapper;
    @Autowired
    private ActDeploymentdetialMapper deploymentDetialMapper;
    @Autowired
    private ActExecutionTaskMapper actExecutionTaskMapper;
    @Autowired
    private ActAgentingMapper actAgentingMapper;
    @Autowired
    private ActExecutionMapper actExecutionMapper;

    private static SnowflakeIdGenerator sfIdGenerator = new SnowflakeIdGenerator();

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    private static final Log logger= LogFactory.get(ActivityServiceImpl.class);


    /**
     * deployid不为空则为流程升版，原版本对应的流程实例保持不变
     * 新增最新版本的流程实例，修改流程定义属性
     * deployid为空则为新增
     *
     * @param jsondata
     * @param deployid
     * @throws Exception
     */
    @Transactional
    @Override
    public void saverOrUpdateDeployment(String jsondata, Long deployid) throws Exception {
        String jsond = Base64Decoder.decodeStr(jsondata, "utf-8");
        JSONObject jsonObject = JSONUtil.parseObj(jsond);
        JSONObject data = JSONUtil.parseObj(jsonObject.get("data"));
        Long[] params = new Long[]{};
        //获取key为data的键值value，此为工作流json数据
        if (data != null && data.size() > 0) {
            if (deployid != null) {
                params = updateDep(data, deployid, jsondata);
            } else {
                params = saveDep(data, jsondata);
            }
            //开始解析父子关系的流程图
            JSONObject nodeConfig = JSONUtil.parseObj(data.get("nodeConfig"));
            //getChildNodes(nodeConfig, params[0], params[1], 0l);
            getChild(nodeConfig, params[0], params[1], 0l);
        } else {
            logger.error(new ActivityException("解析data数据为空，请检查！"));
            throw new ActivityException("解析data数据为空，请检查！");
        }
    }

    /**
     * 递归查询所有childnode
     *
     * @param node            节点对象
     * @param actDeploymentid 流程定义id
     * @param versionCode     流程版本号
     * @param pid             节点父id
     *
     *

    public void getChildNodes(JSONObject node, Long actDeploymentid,
    Long versionCode, Long pid) {
    if (node.get("childNode") instanceof JSONObject) {
    Long dPid = saveDepDetial(node, actDeploymentid, versionCode, pid);
    JSONObject childNode = JSONUtil.parseObj(node.get("childNode"));
    if (childNode.size() > 0)
    getChildNodes(childNode, actDeploymentid, versionCode, dPid);
    } else if (node.get("childNode") instanceof JSONArray) {
    JSONArray childNode = JSONUtil.parseArray(node.get("childNode"));
    for (int i = 0; i < childNode.size(); i++) {
    JSONObject child = childNode.getJSONObject(i);
    if (child.size() > 0)
    getChildNodes(child, actDeploymentid, versionCode, dPid);
    }
    }

    } */

    /**
     * 递归查询所有childnode update 2020年10月14日17:04:48
     *
     * @param node            节点对象
     * @param actDeploymentid 流程定义id
     * @param versionCode     流程版本号
     * @param pid             节点父id
     */
    public void getChild(JSONObject node, Long actDeploymentid,
                         Long versionCode, Long pid) {
        Long dPid = saveDepDetial(node, actDeploymentid, versionCode, pid);
        if (node.get("childNode") instanceof JSONObject) {
            JSONObject childNode = JSONUtil.parseObj(node.get("childNode"));
            if (childNode.size() > 0)
                getChild(childNode, actDeploymentid, versionCode, dPid);
        }
        if (node.get("conditionNodes") instanceof JSONArray) {
            JSONArray childNode = JSONUtil.parseArray(node.get("conditionNodes"));
            for (int i = 0; i < childNode.size(); i++) {
                JSONObject child = childNode.getJSONObject(i);
                if (child.size() > 0)
                    getChild(child, actDeploymentid, versionCode, dPid);
            }
        }

    }

    /**
     * 启动流程
     *
     * @param deployid 流程定义id
     * @param formData 表单信息
     * @param userid   用户id
     */
    @Transactional
    @Override
    public void startActivity(Long deployid, String formData, String userid) throws Exception {
        //表单信息
        String josnFormData = new String(Base64.decode(formData),"UTF-8");
        JSONObject jsonObject = JSONUtil.parseObj(josnFormData);
        //保存任务，返回任务id
        long taskId = saveExecutionSimple(deployid, jsonObject, userid);
        //查找流程实例，开始发送待办任务
        ActDeployment actDeployment = deploymentMapper.selectByPrimaryKey(deployid);
        ActDeploymentdetialExample detialExample = new ActDeploymentdetialExample();
        detialExample.createCriteria().andDeploymentidEqualTo(deployid).andNodeversionEqualTo(actDeployment.getVersioncode());
        List<ActDeploymentdetial> detials = deploymentDetialMapper.selectByExample(detialExample);
        //获取发起人节点id
        Long rootId = detials.stream()
                .filter(detial -> detial.getPid() == 0)
                .collect(Collectors.toList())
                .get(0)
                .getId();
        ActDeploymentdetial childDeploy = detials.stream()
                .filter(child -> child.getPid().equals(rootId))
                .collect(Collectors.toList())
                .get(0);
        queryNextAndSendTask(detials, childDeploy, taskId, jsonObject);
    }

    /**
     * 查询下一环节并发送待办
     *
     * @param detials
     * @param childDeploy
     * @param taskId
     * @param jsonObject
     * @throws Exception
     */
    private void queryNextAndSendTask(List<ActDeploymentdetial> detials,
                                      ActDeploymentdetial childDeploy,
                                      long taskId,
                                      JSONObject jsonObject) throws Exception {
        //type不为路由的情况，审批/抄送，直接发送待办
        if (childDeploy != null) {
            if (childDeploy.getNodetype().equals(NodeTpye.APPROVAL.getType())) {

                insertExecutAndAgentList(childDeploy, taskId);

            } else if (childDeploy.getNodetype().equals(NodeTpye.COPYER.getType())) {
                insertExecutAndAgentList(childDeploy, taskId);

                List<ActDeploymentdetial> copyers = detials.stream()
                        .filter(route -> route.getPid().equals(childDeploy.getId()))
                        .collect(Collectors.toList());
                if (copyers.size() > 0) {

                    queryNextAndSendTask(detials, copyers.get(0), taskId, jsonObject);
                }else
                    queryNextAndSendTask(detials, null, taskId, jsonObject);

            } else if (childDeploy.getNodetype().equals(NodeTpye.ROUTE.getType())) {
                //路由也要存
                insertExecutAndAgentList(childDeploy, taskId);
                List<ActDeploymentdetial> conditions = detials.stream()
                        .filter(route -> route.getPid().equals(childDeploy.getId()))
                        .filter(filter -> filter.getNodetype().equals(NodeTpye.CONDETION.getType()))
                        .collect(Collectors.toList());
                for (int i = 0; i < conditions.size(); i++) {
                    ActDeploymentdetial adm = conditions.get(i);
                    String conditionExpress = adm.getConditionnodes();
                    //如果条件判断成功则修改环节状态，待办状态，并查找下一环节,
                    if (StringUtils.isNotEmpty(conditionExpress) && comparatoExpress(conditionExpress, jsonObject)) {
                        ActDeploymentdetial deploymentdetial = detials.stream()
                                .filter(filterNode -> filterNode.getPid().equals(adm.getId()))
                                .collect(Collectors.toList())
                                .get(0);
                        insertExecutAndAgentList(deploymentdetial, taskId);
                        if (deploymentdetial.getNodetype().equals(NodeTpye.COPYER.getType()))
                            queryNextAndSendTask(detials, childDeploy, taskId, jsonObject);
                    }
                }
            }
        } else {
            ActExecutionTaskExample actExecutionTaskExample = new ActExecutionTaskExample();
            actExecutionTaskExample.createCriteria()
                    .andExecutionidEqualTo(taskId)
                    .andNodetypeEqualTo(NodeTpye.ROUTE.getType())
                    .andNodestatusEqualTo(ExectStatus.PROCESSING.getStatus());
            List<ActExecutionTask> actExecutionTasks = actExecutionTaskMapper.selectByExample(actExecutionTaskExample);
            if (actExecutionTasks.size() > 0 && actExecutionTasks.size() == 1) {
                updateExecutionTaskAndQueryNext(actExecutionTasks.get(0), detials, taskId, jsonObject);
            } else if (actExecutionTasks.size() > 1) {
                //拿到id最大的那个路由
                List<ActExecutionTask> routerids = actExecutionTasks.stream()
                        .sorted((r1, r2) -> {
                            return r1.getDeploymentdetialid()
                                    .compareTo(r2.getDeploymentdetialid());
                        })
                        .collect(Collectors.toList());
                ActExecutionTask router = routerids.get(routerids.size() - 1);
                updateExecutionTaskAndQueryNext(router, detials, taskId, jsonObject);
            } else {
                //路由下的分支都办理完成，流程结束
                ActExecution execution = actExecutionMapper.selectByPrimaryKey(taskId);
                execution.setEndtime(OnlyCode.getCurrentTime());
                execution.setStatus(ExectStatus.COMPLETION.getStatus());
                actExecutionMapper.updateByPrimaryKey(execution);
            }
        }

    }

    /**
     * 环节办理完成修改nodetask的状态并查找下一环节发送待办信息
     *
     * @param actExecutionTask
     * @param detials
     * @param taskId
     * @param jsonObject
     */
    private void updateExecutionTaskAndQueryNext(ActExecutionTask actExecutionTask, List<ActDeploymentdetial> detials, long taskId, JSONObject jsonObject) throws Exception {
        actExecutionTask.setNodestatus(ExectStatus.COMPLETION.getStatus());//设置路由状态，代表已经使用过该路由
        actExecutionTaskMapper.updateByPrimaryKey(actExecutionTask);
        ActDeploymentdetialExample actDeploymentdetialExample = new ActDeploymentdetialExample();
        actDeploymentdetialExample.createCriteria().andPidEqualTo(actExecutionTask.getDeploymentdetialid())
                .andNodetypeNotEqualTo(NodeTpye.CONDETION.getType());
        List<ActDeploymentdetial> actDeploymentdetials = deploymentDetialMapper.selectByExample(actDeploymentdetialExample);
        if (actDeploymentdetials.size() == 0)
            queryNextAndSendTask(detials, null, taskId, jsonObject);
        else
            queryNextAndSendTask(detials, actDeploymentdetials.get(0), taskId, jsonObject);
    }

    /**
     * 为路由的情况，需要往下查找先判断条件分支情况
     *
     * @param detials
     * @param childDeploy
     * @param taskId
     * @param jsonObject
     * @throws Exception

    private void getNextNode(List<ActDeploymentdetial> detials, ActDeploymentdetial childDeploy, long taskId, JSONObject jsonObject) throws Exception {
    List<ActDeploymentdetial> conditions = detials.stream().
    filter(route -> route.getPid().equals(childDeploy.getId()))
    .filter(filter -> filter.getNodetype().equals(NodeTpye.CONDETION.getType()))
    .collect(Collectors.toList());
    for (int i = 0; i < conditions.size(); i++) {
    ActDeploymentdetial adm = conditions.get(i);
    String conditionExpress = adm.getConditionnodes();
    if (comparatoExpress(conditionExpress, jsonObject)) {
    ActDeploymentdetial deploymentdetial = detials.stream()
    .filter(filterNode -> filterNode.getPid().equals(adm.getId()))
    .collect(Collectors.toList())
    .get(0);
    insertExecutAndAgentList(deploymentdetial, taskId);
    }
    }
    } */

    /**
     * 根据办理人查找对应的环节，然后根据该环节的类型。
     * 区分：抄送，审批，条件分支 ，
     * 抄送：只发通知，办不办理不影响流程环节的流转
     * 审批：既发通知，也需要办理。
     * 会签:针对审批环节，审批内的环节办理人必须全部通过，流程才可以向下流转
     * 竞争：针对审批环节，审批内的环节办理人只要有一人办理，流转就可以向下流转
     * 条件分支：需要判断条件表达式，对比表单的属性，通过流转可以向下流转
     *
     * @param agentid
     * @param flag
     * @param rejectToNode
     * @param formdata
     * @param suggestStr
     * @throws Exception
     */
    @Override
    @Transactional
    public void handleActivity(Long agentid, String formdata, String suggestStr, int flag, String rejectToNode) throws Exception {
        //表单信息
        //String josnFormData = new String(Base64.decode(formdata), "utf-8");
        //首先判断任务状态是否正常
        int taskStatus=checkTaskStatus(agentid);
        if (ExectStatus.TASKFIAL.getStatus()!=taskStatus) {
            if (flag==HandleFlag.PASS.getCode()) {
                handlePass(agentid, formdata, suggestStr);
            }
            if (flag== HandleFlag.REJECT.getCode()) {
                handleReject(agentid,rejectToNode);
            }
            if (flag== HandleFlag.CANCEL.getCode()) {
                handCancel(agentid);
            }
        }else{
            throw new ActivityException("该任务已终止，无法办理");
        }
    }

    /**
     * 撤销处理,目前只有审批环节的人员有权限进行撤销操作
     * 修改任务状态为失败
     * @param agentid
     */
    private void handCancel(Long agentid) {
        ActAgenting actAgenting = actAgentingMapper.selectByPrimaryKey(agentid);
        Long taskid = actAgenting.getTaskid();
        Long nownodeid = actAgenting.getNownodeid();
        ActExecutionTaskExample actExecutionTaskExample =new ActExecutionTaskExample();
        actExecutionTaskExample.createCriteria().andDeploymentdetialidEqualTo(nownodeid).andExecutionidEqualTo(taskid);
        List<ActExecutionTask> tasks = actExecutionTaskMapper.selectByExample(actExecutionTaskExample);
        ActExecutionTask actExecutionTask = tasks.get(0);
        if (!actExecutionTask.getNodetype().equals(NodeTpye.APPROVAL.getType())) {
            throw new ActivityException("您没有权限撤销！");
        }
        actAgenting.setAgentingstatus(AgentStatus.CANCEL.getStatus());
        //更新办理人状态我撤销
        actAgentingMapper.updateByPrimaryKey(actAgenting);
        //删除该任务的所有待办任务
        actAgentingMapper.deleteNoCompleteTask(taskid);
        //更新当前环节为撤销
        actExecutionTask.setNodestatus(ExectStatus.TASKFIAL.getStatus());
        actExecutionTaskMapper.updateByPrimaryKey(actExecutionTask);
        //更新任务状态为“审核失败”
        ActExecution execution = actExecutionMapper.selectByPrimaryKey(taskid);
        execution.setStatus(ExectStatus.TASKFIAL.getStatus());
        actExecutionMapper.updateByPrimaryKey(execution);
    }
    /**
     * 检查任务状态
     */
    private int checkTaskStatus(Long agentid){
        ActAgenting actAgenting = actAgentingMapper.selectByPrimaryKey(agentid);
        Long taskid = actAgenting.getTaskid();
        ActExecution execution = actExecutionMapper.selectByPrimaryKey(taskid);
        return execution.getStatus();
    }

    /**
     * 办理驳回的情况
     * 驳回的环节必须是已经完成的环节任务，
     * 并且驳回后，所有还未完成的环节包括
     * 环节对于的待办任务需要删除
     * @param agentid
     * @param rejectToNode
     */
    private void handleReject(Long agentid,String rejectToNode) throws Exception {
        ActAgenting actAgenting = actAgentingMapper.selectByPrimaryKey(agentid);
        //抄送人不可驳回
        if (StringUtils.isNotEmpty(actAgenting)) {
            ActExecutionTask actExecutionTask = actExecutionTaskMapper.selectByPrimaryKey(Long.parseLong(rejectToNode));
            ActDeploymentdetial deploymentdetial = deploymentDetialMapper.selectByPrimaryKey(actExecutionTask.getDeploymentdetialid());
            Long taskid = actAgenting.getTaskid();
            Long nownodeid = actAgenting.getNownodeid();
            ActExecutionTaskExample actExecutionTaskExample =new ActExecutionTaskExample();
            actExecutionTaskExample.createCriteria().andDeploymentdetialidEqualTo(nownodeid).andExecutionidEqualTo(taskid);
            List<ActExecutionTask> tasks = actExecutionTaskMapper.selectByExample(actExecutionTaskExample);
            if (tasks.get(0).getNodetype().equals(NodeTpye.COPYER.getType())) {
                throw new ActivityException("您没有驳回权限！");
            }
            deleteNoCompleteNode(taskid,nownodeid,rejectToNode);
                       //发送待办
            sendHandler(deploymentdetial,taskid);
        }
    }

    /**
     * 删除没有完成的环节任务，并删除对应的待办信息，并修改驳回到这一环节的状态为进行中
     * @param taskid
     * @param nownodeid
     */
    private void deleteNoCompleteNode(Long taskid, Long nownodeid,String rejectToNode) {
        actAgentingMapper.deleteNoCompleteTask(taskid);
        actExecutionTaskMapper.deleteNoCompleteNode(taskid);
        actExecutionTaskMapper.updateNodeStatus(Long.parseLong(rejectToNode));
    }

    /**
     * 办理通过的情况
     * @param agentid
     * @param formdata
     * @param suggestStr
     * @throws Exception
     */
    private synchronized void handlePass(Long agentid, String formdata, String suggestStr) throws Exception {
        //使用threadLoacl的一个线程独立一个副本及弱引用的特性，来存每个线程独有suggestStr
//        threadLocal.set(suggestStr);
        String jsonFormdata=new String(Base64.decode(formdata),"UTF-8");
        JSONObject jsonObject = JSONUtil.parseObj(jsonFormdata);
        ActAgenting actAgenting = actAgentingMapper.selectByPrimaryKey(agentid);
        if (StringUtils.isNotEmpty(actAgenting)) {
            ActDeploymentdetial depDetial = deploymentDetialMapper.selectByPrimaryKey(actAgenting.getNownodeid());
            Integer nodetype = depDetial.getNodetype();
            if (nodetype.equals(NodeTpye.APPROVAL.getType())) {
                if (depDetial.getExecutionmode().equals(ExecutionMode.COUNTERSIGN.getNum())) {
                    String[] nodeUsers = null;
                    if (depDetial.getNodeuserlist().indexOf(",") > 0)
                        nodeUsers = depDetial.getNodeuserlist().split(",");
                    else
                        nodeUsers = new String[]{depDetial.getNodeuserlist()};
                    if (nodeUsers.length > 1) {
                        List<String> signList = Arrays.stream(nodeUsers)
                                .filter(user -> !user.equals(actAgenting.getUseid()))
                                .collect(Collectors.toList());
                        ActAgentingExample agentingExample = new ActAgentingExample();
                        agentingExample.createCriteria().andUseidIn(signList).andNownodeidEqualTo(actAgenting.getNownodeid());
                        List<ActAgenting> actAgentings = actAgentingMapper.selectByExample(agentingExample);
                        long notDoingCount = actAgentings.stream()
                                .filter(others -> others.getAgentingstatus().equals(AgentStatus.NODOING.getStatus()))
                                .count();
                        //该审批环节的所有人员都办理完，修改任务的环节状态，并查找下一节点
                        if (notDoingCount == 0)
                            updateExecutionStatusAndQueryNext(actAgenting, depDetial, jsonObject);
                    } else
                        updateExecutionStatusAndQueryNext(actAgenting, depDetial, jsonObject);
                } else if (depDetial.getExecutionmode()
                        .equals(ExecutionMode.COMPETION.getNum())) {
                   /*
                    *“竞争”关系，只要有一人办理，则环节通过，环节中的其他人的待办任务全部删除
                    */
                    //删除该环节中的其他人的待办任务
                    deleteOthersTasks(actAgenting);
                    //查找下一环节
                    updateExecutionStatusAndQueryNext(actAgenting, depDetial, jsonObject);
                }
            }
            //抄送情况只修改办理人的状态信息
/*            if (nodetype.equals(NodeTpye.COPYER.getType())) {
                ActDeploymentdetialExample actDeploymentdetialExample = new ActDeploymentdetialExample();
                actDeploymentdetialExample.createCriteria()
                        .andDeploymentidEqualTo(depDetial.getDeploymentid())
                        .andNodeversionEqualTo(depDetial.getNodeversion());
                List<ActDeploymentdetial> actDeploymentdetials = deploymentDetialMapper.selectByExample(actDeploymentdetialExample);
                //判断下一环节是否存在，存在则继续查找，不存在只修改办理状态
                List<ActDeploymentdetial> copyers = actDeploymentdetials.stream()
                        .filter(route -> route.getPid().equals(depDetial.getId()))
                        .collect(Collectors.toList());
                if (copyers.size() > 0) {
                    queryNextAndSendTask(actDeploymentdetials, depDetial, actAgenting.getTaskid(), formdata);
                }
            }*/
            /**
             *  修改办理人状态信息,环节状态信息
             */
            updateStatus(actAgenting,suggestStr);

        } else
            throw new ActivityException("根据待办人id查询为空,请检查！");
    }

    private void deleteOthersTasks(ActAgenting actAgenting) {
        ActAgentingExample actAgentingExample=new ActAgentingExample();
        actAgentingExample.createCriteria().andNownodeidEqualTo(actAgenting.getNownodeid())
                .andTaskidEqualTo(actAgenting.getTaskid())
                .andIdNotEqualTo(actAgenting.getId());
        List<ActAgenting> actAgentings = actAgentingMapper.selectByExample(actAgentingExample);
        if (actAgentings.size()>0) {
            for (int i = 0; i < actAgentings.size(); i++) {
                actAgentingMapper.deleteByPrimaryKey(actAgentings.get(i).getId());
            }
        }
    }

    /**
     * 检查环节状态
     * @param actAgenting
     * @return
     */
    private boolean checkNodeStatus(ActAgenting actAgenting) {
        Long taskid = actAgenting.getTaskid();
        Long nownodeid = actAgenting.getNownodeid();
        ActExecutionTaskExample actExecutionTaskExample=new ActExecutionTaskExample();
        actExecutionTaskExample.createCriteria().andExecutionidEqualTo(taskid).andDeploymentdetialidEqualTo(nownodeid);
        List<ActExecutionTask> tasks = actExecutionTaskMapper.selectByExample(actExecutionTaskExample);
        if (tasks.get(0).getNodestatus().equals(ExectStatus.COMPLETION.getStatus())) {
            return true;
        }
        return false;
    }

    /**
     * 修改环节状态并查找下一环节发送待办
     *
     * @param actAgenting
     * @param depDetial
     * @param jsonObject
     */
    private void updateExecutionStatusAndQueryNext(ActAgenting actAgenting, ActDeploymentdetial depDetial, JSONObject jsonObject) throws Exception {
        ActExecutionTaskExample actExecutionTaskExample = new ActExecutionTaskExample();
        actExecutionTaskExample.createCriteria().andDeploymentdetialidEqualTo(actAgenting.getNownodeid());
        ActExecutionTask actExecutionTasks = actExecutionTaskMapper
                .selectByExample(actExecutionTaskExample)
                .get(0);
        actExecutionTasks.setNodestatus(ExectStatus.COMPLETION.getStatus());
        actExecutionTasks.setSendtime(OnlyCode.getCurrentTime());
        actExecutionTaskMapper.updateByPrimaryKey(actExecutionTasks);
        ActDeploymentdetialExample actDeploymentdetialExample = new ActDeploymentdetialExample();
        actDeploymentdetialExample.createCriteria().andDeploymentidEqualTo(depDetial.getDeploymentid()).andNodeversionEqualTo(depDetial.getNodeversion());
        List<ActDeploymentdetial> actDeploymentdetials = deploymentDetialMapper.selectByExample(actDeploymentdetialExample);
        List<ActDeploymentdetial> deploymentdetial = actDeploymentdetials.stream()
                .filter(deploy -> deploy.getPid().equals(actAgenting.getNownodeid()))
                .collect(Collectors.toList());
        if (deploymentdetial.size() == 0) {
            queryNextAndSendTask(actDeploymentdetials, null, actAgenting.getTaskid(), jsonObject);
        } else {
            queryNextAndSendTask(actDeploymentdetials, deploymentdetial.get(0), actAgenting.getTaskid(), jsonObject);
        }
    }

    /**
     * //修改办理人状态，任务环节状态
     *
     * @param actAgenting
     */
    private void updateStatus(ActAgenting actAgenting,String suggestStr) {
        actAgenting.setAgentingstatus(AgentStatus.ISDOING.getStatus());
        actAgenting.setEndtime(OnlyCode.getCurrentTime());
        actAgenting.setSuggeststr(suggestStr);
        actAgentingMapper.updateByPrimaryKey(actAgenting);

        /*
         *判断完成状态分为 “会签”，“竞争”
         * 1.会签需要判断环节所有人都完成，则环节完成
         * 2.竞争则只要一个人完成，则环节完成
         */
        ActDeploymentdetial deploymentdetial = deploymentDetialMapper.selectByPrimaryKey(actAgenting.getNownodeid());
        if (deploymentdetial.getExecutionmode().equals(ExecutionMode.COUNTERSIGN.getNum())) {
            ActAgentingExample actAgentingExample=new ActAgentingExample();
            actAgentingExample.createCriteria().andNownodeidEqualTo(actAgenting.getNownodeid()).andNodeversionEqualTo(actAgenting.getNodeversion());
            List<ActAgenting> actAgentings = actAgentingMapper.selectByExample(actAgentingExample);
            long count = actAgentings.stream()
                    .filter(f -> f.getAgentingstatus().equals(AgentStatus.NODOING.getStatus()))
                    .count();
            if (count==0) {
                updateTaskNodeStatus(actAgenting);
            }
        }
        if (deploymentdetial.getExecutionmode().equals(ExecutionMode.COMPETION.getNum())) {
            updateTaskNodeStatus(actAgenting);
        }
    }

    /**
     * 修改环节状态
     * @param actAgenting
     */
    private void updateTaskNodeStatus(ActAgenting actAgenting) {
        //说明环节下的人全部办理完成，则需要修改环节状态为已完成
        Long taskid = actAgenting.getTaskid();
        Long nownodeid = actAgenting.getNownodeid();
        ActExecutionTaskExample actExecutionTaskExample=new ActExecutionTaskExample();
        actExecutionTaskExample.createCriteria().andExecutionidEqualTo(taskid).andDeploymentdetialidEqualTo(nownodeid);
        List<ActExecutionTask> tasks = actExecutionTaskMapper.selectByExample(actExecutionTaskExample);
        actExecutionTaskMapper.updateStatusComplete(tasks.get(0).getId());
    }


    /**
     * 判断条件表达式
     *
     * @param conditionExpress
     * @param jsonObject
     * @return
     */
    private boolean comparatoExpress(String conditionExpress, JSONObject jsonObject) throws Exception {
        String regEx = "[!=<>]";
        String[] columns = conditionExpress.split(regEx);
        String columnName = columns[0];
        String columnValue = columns[1];
        String comparaflag = conditionExpress.substring(columnName.length(), columnName.length() + 1);
        JSONArray formDataArray = JSONUtil.parseArray(jsonObject.get("formdata"));
        for (int i = 0; i < formDataArray.size(); i++) {
            JSONObject formDataObject = formDataArray.getJSONObject(i);
            String name = (String) formDataObject.get("name");
            String value = (String) formDataObject.get("value");
            if (name.equals(columnName)) {
                return judgementColumn(value, columnValue, comparaflag);
            }
        }
        return false;
    }

    /**
     * 表达式大小比较
     *
     * @param valueColumn
     * @param columnNum
     * @param comparaflag
     * @return
     * @throws Exception
     */
    private boolean judgementColumn(Object valueColumn, String columnNum, String comparaflag) throws Exception {
        boolean comparaF = false;
        switch (comparaflag) {
            case ">":
                if (valueColumn instanceof Integer) {
                    if ((Integer) valueColumn > Integer.parseInt(columnNum))
                        comparaF = true;
                } else if (valueColumn instanceof String) {
                    if (Integer.parseInt((String) valueColumn) > Integer.parseInt(columnNum))
                        comparaF = true;
                } else
                    throw new Exception("不支持的格式！");
                break;
            case "<":
                if (valueColumn instanceof Integer) {
                    if ((Integer) valueColumn > Integer.parseInt(columnNum))
                        comparaF = true;
                } else if (valueColumn instanceof String) {
                    if (Integer.parseInt((String) valueColumn) < Integer.parseInt(columnNum))
                        comparaF = true;
                } else
                    throw new Exception("不支持的格式！");
                break;
            case "=":
                if (valueColumn instanceof Integer) {
                    if ((Integer) valueColumn == Integer.parseInt(columnNum))
                        comparaF = true;
                } else if (valueColumn instanceof String) {
                    if (columnNum.equals((String) valueColumn))
                        comparaF = true;
                } else
                    throw new Exception("不支持的格式！");
                break;
            case ">=":
                if (valueColumn instanceof Integer) {
                    if ((Integer) valueColumn >= Integer.parseInt(columnNum))
                        comparaF = true;
                } else if (valueColumn instanceof String) {
                    if (Integer.parseInt((String) valueColumn) >= Integer.parseInt(columnNum))
                        comparaF = true;
                } else
                    throw new Exception("不支持的格式！");
                break;
            case "<=":
                if (valueColumn instanceof Integer) {
                    if ((Integer) valueColumn <= Integer.parseInt(columnNum))
                        comparaF = true;
                } else if (valueColumn instanceof String) {
                    if (Integer.parseInt((String) valueColumn) < Integer.parseInt(columnNum))
                        comparaF = true;
                } else
                    throw new Exception("不支持的格式！");
                break;
            case "!=":
                if (valueColumn instanceof Integer) {
                    if ((Integer) valueColumn != Integer.parseInt(columnNum))
                        comparaF = true;
                } else if (valueColumn instanceof String) {
                    if (!columnNum.equals((String) valueColumn))
                        comparaF = true;
                } else
                    throw new Exception("不支持的格式！");
                break;
        }
        return comparaF;
    }


    /**
     * 记录流程环节流转情况,并插入待办列表
     *
     * @param childDeploy
     * @param taskId
     */
    private void insertExecutAndAgentList(ActDeploymentdetial childDeploy, long taskId) {
        ActExecutionTask actExecutionTask = new ActExecutionTask();
        actExecutionTask.setId(sfIdGenerator.nextId());
        actExecutionTask.setDeploymentdetialid(childDeploy.getId());
        actExecutionTask.setExecutionid(taskId);
        actExecutionTask.setNodename(childDeploy.getNodename());
        actExecutionTask.setNodestatus(ExectStatus.PROCESSING.getStatus());
        actExecutionTask.setNodetype(childDeploy.getNodetype());
        actExecutionTask.setSendtime(OnlyCode.getCurrentTime());
        actExecutionTaskMapper.insert(actExecutionTask);
        sendHandler(childDeploy,taskId);
    }

    /**
     * 发送待办信息
     * @param childDeploy
     * @param taskId
     */
    private void sendHandler(ActDeploymentdetial childDeploy, long taskId) {
        if (childDeploy.getNodeuserlist() != null) {
            ActAgenting actAgenting = new ActAgenting();
            String[] userids = childDeploy.getNodeuserlist().split(",");
            if (userids.length > 0) {
                for (int i = 0; i < userids.length; i++) {
                    //判断条件：发起人等于待办人跳过
                    if (childDeploy.getJump() != null && childDeploy.getJump()) {
                        ActDeploymentdetialExample actDeploymentdetialExample = new ActDeploymentdetialExample();
                        actDeploymentdetialExample.createCriteria()
                                .andDeploymentidEqualTo(childDeploy.getDeploymentid())
                                .andNodeversionEqualTo(childDeploy.getNodeversion())
                                .andPidEqualTo(0l);
                        List<ActDeploymentdetial> actDeploymentdetials = deploymentDetialMapper.selectByExample(actDeploymentdetialExample);
                        String nodeuserlist = actDeploymentdetials.get(0).getNodeuserlist();
                        if (nodeuserlist.equals(userids[i])) {
                            continue;
                        }
                    }
                    actAgenting.setId(sfIdGenerator.nextId());
                    actAgenting.setUseid(userids[i]);
                    actAgenting.setTaskid(taskId);
                    actAgenting.setAgentingstatus(AgentStatus.NODOING.getStatus());
                    actAgenting.setStarttime(OnlyCode.getCurrentTime());
                    actAgenting.setNownodeid(childDeploy.getId());
//                    actAgenting.setSuggeststr(threadLocal.get());
                    actAgenting.setNodeversion(childDeploy.getNodeversion());
                    actAgentingMapper.insert(actAgenting);
                }
            }
        }
    }

    /**
     * 保存任务
     *
     * @param deployid
     * @param jsonObject
     * @param userid
     * @return
     */
    public long saveExecutionSimple(Long deployid, JSONObject jsonObject, String userid) {
        ActExecution execution = new ActExecution();
        long id = sfIdGenerator.nextId();
        execution.setDeploymentid(deployid);
        execution.setFormid((String) jsonObject.get("formid"));
        execution.setFormname((String) jsonObject.get("formname"));
        execution.setUserid(userid);
        execution.setId(id);
        execution.setStarttime(OnlyCode.getCurrentTime());
        execution.setStatus(ExectStatus.PROCESSING.getStatus());
        actExecutionMapper.insert(execution);
        return id;
    }
    /**
     * 递归查询所有childnode
     *
     * @param node            节点对象
     * @param actDeploymentid 流程定义id
     * @param versionCode     流程版本号
     * @param pid             节点父id

    public void getDeployChilds(JSONObject node, Long actDeploymentid,
    String versionCode, Long pid) {
    Integer nodeType = (Integer) node.get("type");
    //如果节点类型是路由，则先递归路由下的conditionNodes中的childnode
    if (nodeType == NodeTpye.ROUTE.getType()) {
    JSONObject childNode = JSONUtil.parseObj(node.get("childNode"));
    Long routeKey = sfIdGenerator.nextId();//生成路由key，key还是采用雪花算法顺序递增
    Long exportKey = SaveDetial(childNode, actDeploymentid, versionCode, null, routeKey);
    JSONArray conditionNodes = JSONUtil.parseArray(node.get("conditionNodes"));
    if (conditionNodes.size() > 0) {
    for (int i = 0; i < conditionNodes.size(); i++) {
    JSONObject conditionNode = conditionNodes.getJSONObject(i);
    saveActDeploymentdetial(conditionNode, actDeploymentid, versionCode, pid, routeKey);
    }
    }
    //路由的childnode
    JSONObject childNodes = JSONUtil.parseObj(childNode.get("childNode"));
    if (childNodes.size() > 0)
    getDeployChilds(childNodes, actDeploymentid, versionCode, exportKey);
    } else
    saveActDeploymentdetial(node, actDeploymentid, versionCode, pid, null);

    }*/

    /**
     * 保存流程实例
     *
     * @param node
     * @param actDeploymentid
     * @param versionCode
     * @param pid
     * @return
     */
    public Long saveDepDetial(JSONObject node, Long actDeploymentid, Long versionCode,
                              Long pid) {
        StringBuilder sb = new StringBuilder();
        JSONObject copyerList = null;
        ActDeploymentdetial detial = new ActDeploymentdetial();
        Long nodeId = sfIdGenerator.nextId();
        detial.setId(nodeId);
        detial.setPid(pid);
        detial.setDeploymentid(actDeploymentid);
        detial.setNodename((String) node.get("nodeName"));
        detial.setNodetype((Integer) node.get("type"));
        detial.setNodeversion(versionCode);
        detial.setNodecode(node.get("nodeCode") == null ? "" : (String) node.get("nodeCode"));
        detial.setConditionnodes(node.get("expressions") == null ? "" : (String) node.get("expressions"));//条件表达式
        JSONArray nodeUserList = node.get("nodeUserList") != null ? JSONUtil.parseArray(node.get("nodeUserList")) : null;
        if (nodeUserList != null && nodeUserList.size() > 0) {
            copyerList = (JSONObject) node.get("propertyList");
            for (int i = 0; i < nodeUserList.size(); i++) {
                sb.append(nodeUserList.getJSONObject(i).get("targetId") + ",");//userid
            }
            detial.setNodeuserlist(sb.toString().substring(0, sb.toString().length() - 1));
        }
        if (copyerList != null) {
            detial.setExecutionmode((Integer) copyerList.get("executionMode"));////执行方式，1为会签，2为竞争
            detial.setScenecoding((Integer) copyerList.get("sceneCoding"));//场景编码
            detial.setSqlstring((String) copyerList.get("sqlString")); //执行sql脚本
            detial.setJump((Boolean) copyerList.get("jump"));//待办人等于发起人时跳过，true跳过，无此字段默认不跳过
            detial.setHandlertype((Integer) copyerList.get("handlerType")); //代办类型，为1时知会，2为审批
        }
        deploymentDetialMapper.insertSelective(detial);
        return nodeId;
    }

    /**
     * 保存流程定义
     *
     * @param node
     * @param jsondata
     * @return
     */
    public Long[] saveDep(JSONObject node, String jsondata) {
        Long[] longs = new Long[2];
        String deploymentName = (String) node.get("workFlowName");
        ActDeployment actDeployment = new ActDeployment();
        Long actDeploymentid = sfIdGenerator.nextId();
//        Long actVersionCode = Long.parseLong((String) node.get("workFlowVersionId"));
        Long actVersionCode = Long.parseLong(OnlyCode.getVersionCode());
        actDeployment.setJsondata(jsondata);
        actDeployment.setName(deploymentName);
        actDeployment.setVersioncode(actVersionCode);
        actDeployment.setId(actDeploymentid);
        actDeployment.setCreatetime(OnlyCode.getCurrentTime());
        deploymentMapper.insertSelective(actDeployment);
        longs[0] = actDeploymentid;
        longs[1] = actVersionCode;
        return longs;
    }

    /**
     * 修改流程定义信息
     *
     * @param node
     * @param deployid
     * @param jsondata
     * @return
     * @throws Exception
     */
    public Long[] updateDep(JSONObject node, Long deployid, String jsondata) throws Exception {
        Long[] longs = new Long[2];
        ActDeploymentExample actDeploymentExample = new ActDeploymentExample();
        actDeploymentExample.createCriteria().andIdEqualTo(deployid);
        List<ActDeployment> actDeployments = deploymentMapper.selectByExample(actDeploymentExample);
        if (actDeployments.size() > 0) {
            ActDeployment deployment = actDeployments.get(0);
            deployment.setJsondata(jsondata);
            Long versionCode = Long.parseLong(OnlyCode.getVersionCode());
            deployment.setVersioncode(versionCode);
            //deployment.setVersioncode(Long.parseLong((String) node.get("workFlowVersionId")));
            deployment.setName((String) node.get("workFlowName"));
            deploymentMapper.updateByPrimaryKeySelective(deployment);
            longs[0] = deployid;
            longs[1] = versionCode;
            return longs;
        } else {
            logger.error(new ActivityException("根据deployid无法查询对应的流程定义，请检查！"));
            throw new ActivityException("根据deployid无法查询对应的流程定义，请检查！");
        }
    }


/*    public static void main(String[] args) {
        String path = ActivityServiceImpl.class.getClassLoader().getResource("").getPath();
        String path2 = ActivityServiceImpl.class.getResource("/").getPath();
        String path3 = ActivityServiceImpl.class.getResource("").getPath();
        System.out.println(path);
        System.out.println(path2);
        System.out.println(path3);

    }*/
}

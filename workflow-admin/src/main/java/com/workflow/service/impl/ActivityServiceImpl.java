package com.workflow.service.impl;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.workflow.common.enumerate.ExectStatus;
import com.workflow.common.uuid.SnowflakeIdGenerator;
import com.workflow.common.uuid.OnlyCode;
import com.workflow.exception.ActivityException;
import com.workflow.mapper.ActDeploymentMapper;
import com.workflow.mapper.ActDeploymentdetialMapper;
import com.workflow.model.ActDeployment;
import com.workflow.model.ActDeploymentExample;
import com.workflow.model.ActDeploymentdetial;
import com.workflow.model.ActExecution;
import com.workflow.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    private static SnowflakeIdGenerator sfIdGenerator = new SnowflakeIdGenerator();

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
        Long[] params = new Long[2];
        //获取key为data的键值value，此为工作流json数据
        if (data != null && data.size() > 0) {
            if (deployid != null) {
                params = updateDep(data, deployid, jsondata);
            } else {
                params = saveDep(data, jsondata);
            }
            //开始解析父子关系的流程图
            JSONObject nodeConfig = JSONUtil.parseObj(data.get("nodeConfig"));
            getChildNodes(nodeConfig, params[0], params[1], 0l);
        } else
            throw new ActivityException("解析data数据为空，请检查！");

    }

    /**
     * 递归查询所有childnode
     *
     * @param node            节点对象
     * @param actDeploymentid 流程定义id
     * @param versionCode     流程版本号
     * @param pid             节点父id
     */
    public void getChildNodes(JSONObject node, Long actDeploymentid,
                              Long versionCode, Long pid) {
        Long dPid = saveDepDetial(node, actDeploymentid, versionCode, pid);
        if (node.get("childNode") instanceof JSONObject) {
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

    }

    /**
     * 启动流程
     *
     * @param deployid 流程定义id
     * @param formid   表单id
     * @param mutiid   表单实例id
     * @param userid   用户id
     */
    @Transactional
    @Override
    public void startActivity(Long deployid, String formid, String mutiid, String userid) {
        //保存任务，返回任务id
        long taskId = saveExecutionSimple(deployid, formid, mutiid, userid);


    }

    public long saveExecutionSimple(Long deployid, String formid, String mutiid, String userid) {
        ActExecution execution = new ActExecution();
        long id = sfIdGenerator.nextId();
        execution.setDeploymentid(deployid);
        execution.setFormid(formid);
        execution.setMultiid(mutiid);
        execution.setUserid(userid);
        execution.setId(id);
        execution.setStarttime(OnlyCode.getCurrentTime());
        execution.setStatus(ExectStatus.PROCESSING.getStatus());
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
        ActDeploymentdetial detial = new ActDeploymentdetial();
        Long nodeId = sfIdGenerator.nextId();
        detial.setId(nodeId);
        detial.setPid(pid);
        detial.setDeploymentid(actDeploymentid);
        detial.setNodename((String) node.get("nodeName"));
        detial.setNodetype((Integer) node.get("type"));
        detial.setNodeversion(versionCode);
        detial.setNodecode(node.get("nodeCode") == null ? "" : (String) node.get("nodeCode"));
        detial.setConditionnodes(node.get("conditionNodes") == null ? "" : (String) node.get("conditionNodes"));
        detial.setNodeuserlist(node.get("nodeUserList") == null ? "" : (String) node.get("nodeUserList"));
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
        Long actVersionCode = (Long) node.get("workFlowVersionId");
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
            deployment.setVersioncode((Long) node.get("workFlowVersionId"));
            deployment.setName((String) node.get("workFlowName"));
            deploymentMapper.updateByPrimaryKeySelective(deployment);
            longs[0] = deployid;
            longs[1] = (Long) node.get("workFlowVersionId");
            return longs;
        } else
            throw new ActivityException("根据deployid无法查询对应的流程定义，请检查！");
    }


    public static void main(String[] args) {
        String path = ActivityServiceImpl.class.getClassLoader().getResource("").getPath();
        String path2 = ActivityServiceImpl.class.getResource("/").getPath();
        String path3 = ActivityServiceImpl.class.getResource("").getPath();
        System.out.println(path);
        System.out.println(path2);
        System.out.println(path3);

    }
}

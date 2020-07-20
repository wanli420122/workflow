package com.workflow.service.impl;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.workflow.common.api.NodeTpye;
import com.workflow.common.api.StringUtils;
import com.workflow.common.uuid.SnowflakeIdGenerator;
import com.workflow.common.uuid.OnlyCode;
import com.workflow.mapper.ActDeploymentMapper;
import com.workflow.mapper.ActDeploymentdetialMapper;
import com.workflow.model.ActDeployment;
import com.workflow.model.ActDeploymentdetial;
import com.workflow.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    private static SnowflakeIdGenerator sfIdGenerator=new SnowflakeIdGenerator();

    @Transactional
    @Override
    public void saverOrUpdateDeployment(String jonsdata) {
        String jsond=Base64Decoder.decodeStr(jonsdata,"utf-8");
        JSONObject jsonObject= JSONUtil.parseObj(jsond);
        //获取key为data的键值value，此为工作流json数据
        JSONObject data=JSONUtil.parseObj(jsonObject.get("data"));
        JSONObject workFlowDef=JSONUtil.parseObj(data.get("workFlowDef"));
        String deploymentName=(String)workFlowDef.get("name");
        ActDeployment actDeployment=new ActDeployment();
        String actDeploymentid=String.valueOf(sfIdGenerator.nextId());
        String versionCode=OnlyCode.getVersionCode();
        actDeployment.setJsondata(jonsdata);
        actDeployment.setName(deploymentName);
        actDeployment.setVersioncode(versionCode);
        actDeployment.setId(actDeploymentid);
        actDeployment.setCreatetime(OnlyCode.getCurrentTime());
        deploymentMapper.insertSelective(actDeployment);
        //开始解析父子关系的流程图
        JSONObject nodeConfig=JSONUtil.parseObj(data.get("nodeConfig"));
        getDeployChilds(nodeConfig,actDeploymentid,versionCode,null);
    }

    /**
     * 递归查询所有childnode
     * @param node 节点对象
     * @param actDeploymentid 流程定义id
     * @param versionCode     流程版本号
     * @param pid             节点父id
     */
    public void getDeployChilds(JSONObject node,String actDeploymentid,
                                String versionCode,String pid){
        if(StringUtils.isEmpty(pid))
            pid="start-node";
        Integer nodeType= (Integer) node.get("type");
        //如果节点类型是路由，则先递归路由下的conditionNodes中的childnode
        if (nodeType==NodeTpye.ROUTE.getType()) {
            JSONObject childNode=JSONUtil.parseObj(node.get("childNode"));
            String routeKey=String.valueOf(sfIdGenerator.nextId());
            String exportKey=saveActDeploymentdetial(childNode,actDeploymentid,versionCode,null,routeKey,null);
            JSONArray conditionNodes=JSONUtil.parseArray(node.get("conditionNodes"));
            //StringBuffer pids=new StringBuffer();
            if(conditionNodes.size()>0){
                for(int i=0;i<conditionNodes.size();i++){
                    JSONObject conditionNode=conditionNodes.getJSONObject(i);
                    String id=saveActDeploymentdetial(conditionNode,actDeploymentid,versionCode,pid,routeKey,exportKey);
//                    if (!StringUtils.isEmpty(id))
//                        pids.append(id+",");
                }
            }
            //路由的childnode
            if(childNode.size()>0)
                saveActDeploymentdetial(childNode,actDeploymentid,versionCode,exportKey,null,null);
        }else
            saveActDeploymentdetial(node,actDeploymentid,versionCode,pid,null,null);

    }

    public String SaveD(JSONObject node,String actDeploymentid,String versionCode,
                        String pid,String routeKey,String exportKey){
        ActDeploymentdetial detial=new ActDeploymentdetial();
        Integer nodeType=(Integer) node.get("type");
        String nodeId=String.valueOf(sfIdGenerator.nextId());
        String nodeName=(String)node.get("nodeName");
        detial.setId(nodeId);
        detial.setPid(pid);
        detial.setDeploymentid(actDeploymentid);
        detial.setNodename(nodeName);
        detial.setNodetype(nodeType);
        detial.setNodeversion(versionCode);
        detial.setBelongroute(routeKey==null?"":routeKey);
        detial.setExportroute(exportKey==null?"":exportKey);
        deploymentDetialMapper.insertSelective(detial);
        return nodeId;
    }

    /**
     * 保存流程定义，并返回childnode为空的id
     * @param node
     * @param actDeploymentid
     * @param versionCode
     * @param pid
     * @return
     */
    public String saveActDeploymentdetial(JSONObject node,String actDeploymentid,String versionCode,
                                          String pid,String routeKey,String exportKey){
        ActDeploymentdetial detial=new ActDeploymentdetial();
        Integer nodeType=(Integer) node.get("type");
        String nodeId=String.valueOf(sfIdGenerator.nextId());
        String nodeName=(String)node.get("nodeName");
        detial.setId(nodeId);
        detial.setPid(pid);
        detial.setDeploymentid(actDeploymentid);
        detial.setNodename(nodeName);
        detial.setNodetype(nodeType);
        detial.setNodeversion(versionCode);
        detial.setBelongroute(routeKey==null?"":routeKey);
        detial.setExportroute(exportKey==null?"":exportKey);
        deploymentDetialMapper.insertSelective(detial);
        Object child = node.get("childNode");
        JSONObject childNode=JSONUtil.parseObj(child);
        if (childNode.size()>0) {
            getDeployChilds(childNode,actDeploymentid,versionCode,nodeId);
        }
        return nodeId;
    }
}

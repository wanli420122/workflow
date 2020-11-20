package com.workflow.service.impl;

import com.workflow.common.enumerate.AgentStatus;
import com.workflow.common.uuid.SnowflakeIdGenerator;
import com.workflow.exception.ActivityException;
import com.workflow.mapper.ActAgentingMapper;
import com.workflow.mapper.ActDeploymentMapper;
import com.workflow.mapper.ActExecutionTaskMapper;
import com.workflow.model.*;
import com.workflow.service.QueryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by wl on 2020/11/2
 */
@Service
public class QueryDataServiceImpl implements QueryDataService {

    private static final SnowflakeIdGenerator sfIdGenerator = new SnowflakeIdGenerator();

    @Autowired
    ActDeploymentMapper actDeploymentMapper;

    @Autowired
    ActAgentingMapper actAgentingMapper;

    @Autowired
    ActExecutionTaskMapper actExecutionTaskMapper;

    @Override
    public List<ActDeployment> queryDeplymentList() throws Exception {
        ActDeploymentExample example =new ActDeploymentExample();
        example.createCriteria().getAllCriteria();
        return actDeploymentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void updateDeployment(ActDeployment deployid) throws Exception {
        ActDeployment actDeployment = actDeploymentMapper.selectByPrimaryKey(deployid.getId());
        if (actDeployment==null)
            throw new ActivityException("根据流程定义id无法查询对应数据！");
        else
            actDeploymentMapper.updateByPrimaryKey(deployid);

    }

    @Override
    public void addDeployment(ActDeployment actDeployment) throws Exception {
        actDeployment.setId(sfIdGenerator.nextId());
        actDeploymentMapper.insertSelective(actDeployment);
    }

    @Override
    public void deleteDeployment(Long deployid) throws Exception {
        ActDeployment actDeployment = actDeploymentMapper.selectByPrimaryKey(deployid);
        if (actDeployment==null)
            throw new ActivityException("根据流程定义id无法查询对应数据！");
        else
            actDeploymentMapper.deleteByPrimaryKey(deployid);
    }

    @Override
    public List<Map> queryTaskLists(String userid, String flag) throws Exception {
        if (!StringUtils.isEmpty(userid) && !StringUtils.isEmpty(flag)) {
            if(userid.equals("sa")){
                List<Map> actAgentings = actAgentingMapper.queryAgentingAllLists(flag);
                return actAgentings;
            }
            List<Map> actAgentings = actAgentingMapper.queryAgentingLists(userid, flag);
            return actAgentings;
        }
        return null;
    }

    @Override
    public List<Map> queryExectionNodes(String agentingid) {
        List<Map> nodes=new ArrayList<>();
        if (!StringUtils.isEmpty(agentingid)) {
            ActAgenting actAgenting = actAgentingMapper.selectByPrimaryKey(Long.parseLong(agentingid));
            ActExecutionTaskExample actExecutionTaskExample=new ActExecutionTaskExample();
            actExecutionTaskExample.setOrderByClause("id");
            actExecutionTaskExample.createCriteria().andExecutionidEqualTo(actAgenting.getTaskid())
                    .andNodetypeNotEqualTo(4);
            List<ActExecutionTask> actExecutionTasks = actExecutionTaskMapper.selectByExample(actExecutionTaskExample);
            for (int i = 0; i < actExecutionTasks.size(); i++) {
                Map<String,Object> m=new HashMap<>();
                List<Map> actlists=new ArrayList<>();
                ActAgentingExample actAgentingExample=new ActAgentingExample();
                actAgentingExample.createCriteria().andTaskidEqualTo(actExecutionTasks.get(i).getExecutionid())
                        .andNownodeidEqualTo(actExecutionTasks.get(i).getDeploymentdetialid());
                List<ActAgenting> actAgentings = actAgentingMapper.selectByExample(actAgentingExample);
                m.put("nodeName",actExecutionTasks.get(i).getNodename());
                m.put("nodeStatus",actExecutionTasks.get(i).getNodestatus());
                m.put("nodeType",actExecutionTasks.get(i).getNodetype());
                for (int j = 0; j <actAgentings.size() ; j++) {
                    ActAgenting agenting=actAgentings.get(j);
                    Map<String,Object> amap=new HashMap<>();
                    amap.put("userid",agenting.getUseid());
                    amap.put("agentingStatus",agenting.getAgentingstatus());
                    amap.put("agentingSign",agenting.getAgentingsign());
                    amap.put("startTime",agenting.getStarttime());
                    amap.put("endTime",agenting.getEndtime());
                    amap.put("suggestStr",agenting.getSuggeststr());
                    actlists.add(amap);
                }
                m.put("nodeDetails",actlists);
                nodes.add(m);
            }
        }
        return nodes;
    }
}

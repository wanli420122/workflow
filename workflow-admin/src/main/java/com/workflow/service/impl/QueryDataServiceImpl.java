package com.workflow.service.impl;

import com.workflow.common.uuid.SnowflakeIdGenerator;
import com.workflow.exception.ActivityException;
import com.workflow.mapper.ActDeploymentMapper;
import com.workflow.model.ActDeployment;
import com.workflow.model.ActDeploymentExample;
import com.workflow.model.ActExecution;
import com.workflow.service.QueryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by wl on 2020/11/2
 */
@Service
public class QueryDataServiceImpl implements QueryDataService {

    private static final SnowflakeIdGenerator sfIdGenerator = new SnowflakeIdGenerator();

    @Autowired
    ActDeploymentMapper actDeploymentMapper;
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
}

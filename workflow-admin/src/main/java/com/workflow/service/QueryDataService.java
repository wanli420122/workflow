package com.workflow.service;

import com.workflow.model.ActAgenting;
import com.workflow.model.ActDeployment;
import com.workflow.model.ActExecutionTask;

import java.util.List;
import java.util.Map;

public interface QueryDataService {
    List<ActDeployment> queryDeplymentList() throws Exception;

    void updateDeployment(ActDeployment deployid) throws Exception ;

    void addDeployment(ActDeployment actDeployment)throws Exception;

    void deleteDeployment(Long deployid)throws Exception;

    List<Map> queryTaskLists(String userid, String flag)throws Exception;

    List<Map> queryExectionNodes(String agentingid);

    int queryTaskStatus(String agentingid);

    List<ActExecutionTask> queryCanRejectNode(String agentingid)throws Exception;
}

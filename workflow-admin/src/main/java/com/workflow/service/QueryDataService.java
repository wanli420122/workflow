package com.workflow.service;

import com.workflow.model.ActDeployment;

import java.util.List;

public interface QueryDataService {
    List<ActDeployment> queryDeplymentList() throws Exception;

    void updateDeployment(ActDeployment deployid) throws Exception ;

    void addDeployment(ActDeployment actDeployment)throws Exception;

    void deleteDeployment(Long deployid)throws Exception;
}

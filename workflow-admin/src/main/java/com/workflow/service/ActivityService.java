package com.workflow.service;

public interface ActivityService {
    void saverOrUpdateDeployment(String jonsdata,Long deployid) throws Exception;

    void startActivity(Long deployid, String formData, String userid) throws  Exception;

    void handleActivity(Long agentid, String formdata, String suggestStr)throws Exception;
}

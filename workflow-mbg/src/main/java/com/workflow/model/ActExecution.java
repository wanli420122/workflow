package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActExecution implements Serializable {
    private String id;

    @ApiModelProperty(value = "流程定义表id")
    private String deploymentid;

    @ApiModelProperty(value = "表单id")
    private String formid;

    @ApiModelProperty(value = "执行表单id")
    private String multiid;

    @ApiModelProperty(value = "用户id")
    private String userid;

    @ApiModelProperty(value = "任务执行状态 0-审核中 1-审核通过 2-审核不通过")
    private Integer status;

    @ApiModelProperty(value = "开始执行任务时间")
    private Date starttime;

    @ApiModelProperty(value = "结束执行任务时间")
    private Date endtime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeploymentid() {
        return deploymentid;
    }

    public void setDeploymentid(String deploymentid) {
        this.deploymentid = deploymentid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getMultiid() {
        return multiid;
    }

    public void setMultiid(String multiid) {
        this.multiid = multiid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deploymentid=").append(deploymentid);
        sb.append(", formid=").append(formid);
        sb.append(", multiid=").append(multiid);
        sb.append(", userid=").append(userid);
        sb.append(", status=").append(status);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActExecutionTask implements Serializable {
    private Long id;

    private Long executionid;

    private Long deploymentdetialid;

    private String nodename;

    private Integer nodestatus;

    private Integer nodetype;

    private Date sendtime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExecutionid() {
        return executionid;
    }

    public void setExecutionid(Long executionid) {
        this.executionid = executionid;
    }

    public Long getDeploymentdetialid() {
        return deploymentdetialid;
    }

    public void setDeploymentdetialid(Long deploymentdetialid) {
        this.deploymentdetialid = deploymentdetialid;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public Integer getNodestatus() {
        return nodestatus;
    }

    public void setNodestatus(Integer nodestatus) {
        this.nodestatus = nodestatus;
    }

    public Integer getNodetype() {
        return nodetype;
    }

    public void setNodetype(Integer nodetype) {
        this.nodetype = nodetype;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", executionid=").append(executionid);
        sb.append(", deploymentdetialid=").append(deploymentdetialid);
        sb.append(", nodename=").append(nodename);
        sb.append(", nodestatus=").append(nodestatus);
        sb.append(", nodetype=").append(nodetype);
        sb.append(", sendtime=").append(sendtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
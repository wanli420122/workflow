package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ActExecutionTask implements Serializable {
    private String id;

    @ApiModelProperty(value = "流程执行id")
    private String executionid;

    @ApiModelProperty(value = "流程实例id")
    private String deploymentdetialid;

    @ApiModelProperty(value = "节点名称")
    private String nodename;

    @ApiModelProperty(value = "节点执行状态 0-办理中 1-办理通过 2-驳回")
    private Integer nodestatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExecutionid() {
        return executionid;
    }

    public void setExecutionid(String executionid) {
        this.executionid = executionid;
    }

    public String getDeploymentdetialid() {
        return deploymentdetialid;
    }

    public void setDeploymentdetialid(String deploymentdetialid) {
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
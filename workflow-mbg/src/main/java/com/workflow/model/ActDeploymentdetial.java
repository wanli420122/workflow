package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ActDeploymentdetial implements Serializable {
    private String id;

    private String deploymentid;

    private String pid;

    private String nodename;

    private String nodeversion;

    private String belongroute;

    private String exportroute;

    private Integer nodetype;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getNodeversion() {
        return nodeversion;
    }

    public void setNodeversion(String nodeversion) {
        this.nodeversion = nodeversion;
    }

    public String getBelongroute() {
        return belongroute;
    }

    public void setBelongroute(String belongroute) {
        this.belongroute = belongroute;
    }

    public String getExportroute() {
        return exportroute;
    }

    public void setExportroute(String exportroute) {
        this.exportroute = exportroute;
    }

    public Integer getNodetype() {
        return nodetype;
    }

    public void setNodetype(Integer nodetype) {
        this.nodetype = nodetype;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deploymentid=").append(deploymentid);
        sb.append(", pid=").append(pid);
        sb.append(", nodename=").append(nodename);
        sb.append(", nodeversion=").append(nodeversion);
        sb.append(", belongroute=").append(belongroute);
        sb.append(", exportroute=").append(exportroute);
        sb.append(", nodetype=").append(nodetype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
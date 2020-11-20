package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ActDeploymentdetial implements Serializable {
    private Long id;

    private Long deploymentid;

    private Long pid;

    private String nodecode;

    private String nodename;

    private Long nodeversion;

    private Long belongroute;

    private Integer nodetype;

    private String nodeuserlist;

    private String conditionnodes;

    private Integer executionmode;

    private Integer scenecoding;

    private String sqlstring;

    private Boolean jump;

    private Integer handlertype;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeploymentid() {
        return deploymentid;
    }

    public void setDeploymentid(Long deploymentid) {
        this.deploymentid = deploymentid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public Long getNodeversion() {
        return nodeversion;
    }

    public void setNodeversion(Long nodeversion) {
        this.nodeversion = nodeversion;
    }

    public Long getBelongroute() {
        return belongroute;
    }

    public void setBelongroute(Long belongroute) {
        this.belongroute = belongroute;
    }

    public Integer getNodetype() {
        return nodetype;
    }

    public void setNodetype(Integer nodetype) {
        this.nodetype = nodetype;
    }

    public String getNodeuserlist() {
        return nodeuserlist;
    }

    public void setNodeuserlist(String nodeuserlist) {
        this.nodeuserlist = nodeuserlist;
    }

    public String getConditionnodes() {
        return conditionnodes;
    }

    public void setConditionnodes(String conditionnodes) {
        this.conditionnodes = conditionnodes;
    }

    public Integer getExecutionmode() {
        return executionmode;
    }

    public void setExecutionmode(Integer executionmode) {
        this.executionmode = executionmode;
    }

    public Integer getScenecoding() {
        return scenecoding;
    }

    public void setScenecoding(Integer scenecoding) {
        this.scenecoding = scenecoding;
    }

    public String getSqlstring() {
        return sqlstring;
    }

    public void setSqlstring(String sqlstring) {
        this.sqlstring = sqlstring;
    }

    public Boolean getJump() {
        return jump;
    }

    public void setJump(Boolean jump) {
        this.jump = jump;
    }

    public Integer getHandlertype() {
        return handlertype;
    }

    public void setHandlertype(Integer handlertype) {
        this.handlertype = handlertype;
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
        sb.append(", nodecode=").append(nodecode);
        sb.append(", nodename=").append(nodename);
        sb.append(", nodeversion=").append(nodeversion);
        sb.append(", belongroute=").append(belongroute);
        sb.append(", nodetype=").append(nodetype);
        sb.append(", nodeuserlist=").append(nodeuserlist);
        sb.append(", conditionnodes=").append(conditionnodes);
        sb.append(", executionmode=").append(executionmode);
        sb.append(", scenecoding=").append(scenecoding);
        sb.append(", sqlstring=").append(sqlstring);
        sb.append(", jump=").append(jump);
        sb.append(", handlertype=").append(handlertype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
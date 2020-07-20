package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActAgenting implements Serializable {
    private String id;

    @ApiModelProperty(value = "执行任务id")
    private String taskid;

    @ApiModelProperty(value = "办理人id")
    private String useid;

    @ApiModelProperty(value = "办理状态 0-代办  1-已办")
    private Integer agentingstatus;

    @ApiModelProperty(value = "办理标识 0-通过 1-驳回")
    private Integer agentingsign;

    @ApiModelProperty(value = "开始时间")
    private Date starttime;

    @ApiModelProperty(value = "结束时间")
    private Date endtime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getUseid() {
        return useid;
    }

    public void setUseid(String useid) {
        this.useid = useid;
    }

    public Integer getAgentingstatus() {
        return agentingstatus;
    }

    public void setAgentingstatus(Integer agentingstatus) {
        this.agentingstatus = agentingstatus;
    }

    public Integer getAgentingsign() {
        return agentingsign;
    }

    public void setAgentingsign(Integer agentingsign) {
        this.agentingsign = agentingsign;
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
        sb.append(", taskid=").append(taskid);
        sb.append(", useid=").append(useid);
        sb.append(", agentingstatus=").append(agentingstatus);
        sb.append(", agentingsign=").append(agentingsign);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
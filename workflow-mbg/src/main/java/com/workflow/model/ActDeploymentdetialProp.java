package com.workflow.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ActDeploymentdetialProp implements Serializable {
    private Long id;

    private Long nodeid;

    private String organizationid;

    private String roleid;

    private String userid;

    private String conditionpress;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNodeid() {
        return nodeid;
    }

    public void setNodeid(Long nodeid) {
        this.nodeid = nodeid;
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getConditionpress() {
        return conditionpress;
    }

    public void setConditionpress(String conditionpress) {
        this.conditionpress = conditionpress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nodeid=").append(nodeid);
        sb.append(", organizationid=").append(organizationid);
        sb.append(", roleid=").append(roleid);
        sb.append(", userid=").append(userid);
        sb.append(", conditionpress=").append(conditionpress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
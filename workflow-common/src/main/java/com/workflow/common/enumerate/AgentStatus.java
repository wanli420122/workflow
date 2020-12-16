package com.workflow.common.enumerate;

/**
 * 待办已办枚举类
 * author：wanli
 * time:2020年10月23日15:00:59
 */
public enum AgentStatus {
    NODOING(0,"待办"),
    ISDOING(1,"已办"),
    CANCEL(2,"撤销");
    private int status;
    private String des;
    AgentStatus(int status, String des ){
        this.status=status;
        this.des=des;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

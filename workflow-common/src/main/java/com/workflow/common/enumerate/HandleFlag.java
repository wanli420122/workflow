package com.workflow.common.enumerate;

/**
 * 办理标识，枚举类
 * 2020年12月8日15:26:25
 * wanli
 */
public enum HandleFlag {
    PASS(0,"通过"),
    REJECT(1,"驳回"),
    CANCEL(2,"撤销");
    private int code;
    private String desc;

    HandleFlag(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

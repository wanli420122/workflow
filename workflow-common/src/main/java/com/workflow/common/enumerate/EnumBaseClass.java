package com.workflow.common.enumerate;

public enum EnumBaseClass {

    ;

    EnumBaseClass(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    
    private String desc;

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

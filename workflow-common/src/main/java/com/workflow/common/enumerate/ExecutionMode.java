package com.workflow.common.enumerate;

/**
 * 执行方式枚举类
 * author：wanli
 * time:2020年10月26日13:39:04
 */
public enum ExecutionMode {
    COUNTERSIGN(0,"会签"),
    COMPETION(1,"竞争");

    private int num;
    private String desc;

    ExecutionMode(int num,String desc) {
        this.num=num;
        this.desc=desc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

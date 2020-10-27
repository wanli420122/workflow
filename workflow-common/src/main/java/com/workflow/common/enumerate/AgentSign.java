package com.workflow.common.enumerate;

/**
 * 待办已办枚举类
 * author:wanli
 * time:2020年10月23日14:42:22
 */
public enum AgentSign {
    PASS(0,"通过"),
    AGAINST(1,"驳回");

    private int sign;

    private String description;

    AgentSign(int sign, String description) {
        this.sign=sign;
        this.description=description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}

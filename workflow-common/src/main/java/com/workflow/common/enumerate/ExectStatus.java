package com.workflow.common.enumerate;
/*
 *执行任务状态枚举类
 * 2020年8月4日09:45:45
 * author ：wanli
 */
public enum ExectStatus {
    PROCESSING(0,"任务进行中"),
    COMPLETION(1,"任务已完成"),
    TASKFIAL(2,"任务执行失败");
    private int status;
    private String description;

    ExectStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

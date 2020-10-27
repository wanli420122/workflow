package com.workflow.exception;

/**
 * 工作流异常处理类
 * Create by wl on 2020/8/27
 */
public class ActivityException extends RuntimeException{
    private String msg;

    public  ActivityException(){
        super();
    }

   public ActivityException(String msg){
        super(msg);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

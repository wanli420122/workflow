package com.workflow.common.api;

/**
 * 封装API的错误码
 * Created by wanli on 2020/7/15.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}

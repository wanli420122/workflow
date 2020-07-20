package com.workflow.common.exception;


import com.workflow.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by wanli on 2020/7/15.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}

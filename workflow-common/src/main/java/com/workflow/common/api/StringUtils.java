package com.workflow.common.api;

/**
 * Create by wl on 2020/7/17
 */
public class StringUtils {

    public static boolean isEmpty(Object obj) {
        if (obj == null)
            return true;
        if (obj instanceof String) {
            String str = (String) obj;
            return str.equals("") || str.equals("null");
        }
        return false;
    }
}

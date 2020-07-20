package com.workflow.common.uuid;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取唯一版(流程)本号
 * Create by wl on 2020/7/16
 */
public class OnlyCode {


    public synchronized static String getVersionCode(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    public static Date getCurrentTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar= Calendar.getInstance();
        String nowTime=sdf.format(calendar.getTime());
        return sdf.parse(nowTime,new ParsePosition(0));
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date= OnlyCode.getCurrentTime();
        System.out.println(sdf.format(date));
    }
}

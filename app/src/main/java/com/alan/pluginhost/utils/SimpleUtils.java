package com.alan.pluginhost.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SimpleUtils {

    private static final SimpleDateFormat dateFormater1 = new SimpleDateFormat("yyyy-MM-dd");

    public static List<String> toList(String data) {
        return null;
    }

    public static <T> T json2Pojo(String jsonStr, Class<T> cls) {
        T obj = null;
        return null;
    }


    /**
     * 以友好的方式显示时间
     *
     * @param time
     * @return
     */
    public static String getFriendlyTime(Date time) {
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater1.format(cal.getTime());
        String paramDate = dateFormater1.format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0) {
                if (((cal.getTimeInMillis() - time.getTime()) / 60000) < 1) {
                    ftime = "刚刚";
                } else {
                    ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1) + "分钟前";
                }
            } else {
                ftime = hour + "小时前";
            }
            return ftime;
        }

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
        } else if (days == 1) {
            ftime = "昨天";
        } else if (days == 2) {
            ftime = "前天";
        } else if (days > 2) {
            ftime = days + "天前";
        }
        return ftime;
    }

}

package com.alan.pluginhost;

import android.content.Context;


public class CacheUtils {

    public static void setCache(Context context, String url, String result) {
        SharedPrerensUtils.setString(context, url, result);
    }

    public static String getCache(Context context, String url) {
        return SharedPrerensUtils.getString(context, url);
    }
}

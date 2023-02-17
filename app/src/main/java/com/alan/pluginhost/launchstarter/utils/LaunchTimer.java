package com.alan.pluginhost.launchstarter.utils;

import android.util.Log;

public class LaunchTimer {
    private static long sTime;

    public static void startRecord() {
        sTime = System.currentTimeMillis();
    }

    public static void endRecord() {
        long cost = System.currentTimeMillis() - sTime;
        Log.e("TAG", "cost time" + cost);
    }
}

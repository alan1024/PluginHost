package com.alan.pluginhost.utils;


import com.alan.pluginhost.utils.log.LogManager;

public class LogUtils {

    public static void i(String tag, String msg) {
        if (true) {
            LogManager.getLogger().i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (true) {
            LogManager.getLogger().v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (true) {
            LogManager.getLogger().d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (true) {
            LogManager.getLogger().w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (true) {
            LogManager.getLogger().e(tag, msg);
        }
    }

    // == Log Throwable ===========
    public static void i(String tag, String msg, Throwable tr) {
        if (true) {
            LogManager.getLogger().i(tag, msg, tr);
        }
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (true) {
            LogManager.getLogger().v(tag, msg, tr);
        }
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (true) {
            LogManager.getLogger().d(tag, msg, tr);
        }
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (true) {
            LogManager.getLogger().w(tag, msg, tr);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (true) {
            LogManager.getLogger().e(tag, msg, tr);
        }
    }

}

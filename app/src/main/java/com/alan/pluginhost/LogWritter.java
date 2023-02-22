package com.alan.pluginhost;

import android.util.Config;
import android.util.Log;

import java.util.logging.Logger;

public class LogWritter extends Logger {

    protected LogWritter(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public static void LogStr(String string) {
        if (Config.DEBUG) {
            Log.i("PandaEye", string);
        }
    }
}

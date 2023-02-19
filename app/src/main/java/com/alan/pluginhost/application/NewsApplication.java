package com.alan.pluginhost.application;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.alan.pluginhost.utils.LogUtils;


public class NewsApplication extends Application {
    private static Context newsContext;

    @Override
    public void onCreate() {
        LogUtils.d("dshfau", "onCreate()");
        super.onCreate();
        newsContext = getApplicationContext();
    }

    public static Context getNewsContext() {
        return newsContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

package com.alan.pluginhost.app;

import android.app.Application;
import android.content.Context;


public class SeeNewsApp extends Application {


    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * clear 类库
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

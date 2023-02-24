package com.alan.pluginhost.vollley;

import android.content.Context;

public class MySingleton {
    private static MySingleton mInstance;
    private static Context mCtx;

    private MySingleton(Context context) {
        mCtx = context;


    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }


}
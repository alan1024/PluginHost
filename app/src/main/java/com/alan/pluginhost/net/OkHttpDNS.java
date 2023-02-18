package com.alan.pluginhost.net;

import android.content.Context;


public class OkHttpDNS {
    private static OkHttpDNS instance = null;

    private OkHttpDNS(Context context) {
        //第二个参数阿里云的id,不可为空
    }

    public static OkHttpDNS getInstance(Context context) {
        if (instance == null) {
            synchronized (OkHttpDNS.class) {
                if (instance == null) {
                    instance = new OkHttpDNS(context);
                }
            }
        }
        return instance;
    }
}

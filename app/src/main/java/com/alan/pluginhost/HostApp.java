package com.alan.pluginhost;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.qihoo360.replugin.RePluginApplication;

import java.util.Map;

public class HostApp extends RePluginApplication {
    public static final String AF_KEY = "BjbZ8Y5WdjqF9Vu7mxYqeW";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e("xujm", "123");

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        init(this, AF_KEY);
    }

    public void init(Application context, String af_dev_key) {
        Log.e("xujm", "AppsFlyer注册key:" + af_dev_key);
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {
                Log.e("xujm", "AppsFlyer初始化成功");
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.e("xujm", "AppsFlyer初始化失败" + errorMessage);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> conversionData) {
                Log.e("xujm", "AppsFlyer属性成功：" + conversionData.toString());

            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.e("xujm", "AppsFlyer属性失败：" + errorMessage);
            }
        };
        AppsFlyerLib.getInstance().init(af_dev_key, conversionListener, context);
        AppsFlyerLib.getInstance().setDebugLog(true);
        AppsFlyerLib.getInstance().start(context);
    }


}

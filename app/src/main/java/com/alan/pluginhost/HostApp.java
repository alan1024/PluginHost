package com.alan.pluginhost;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.qihoo360.replugin.RePluginApplication;

import java.util.Map;

public class HostApp extends RePluginApplication {
    public static final String AF_KEY = "GFMADKCDDtzsUubS58QVGA";
    public static volatile HostApp instance;


    public static HostApp getInstance(){
        if (instance == null) {
            synchronized (HostApp.class){
                if (instance == null) {
                    instance = new HostApp();
                }
            }
        }
        return instance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

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

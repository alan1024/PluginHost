package com.alan.pluginhost;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.alan.pluginhost.google.GoogleInstallReferrer;
import com.alan.pluginhost.google.ProcessUtil;
import com.alan.pluginhost.google.entity.FireBase;
import com.alan.pluginhost.google.entity.Referrer;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.qihoo360.replugin.RePluginApplication;

import java.util.Map;

public class HostApp extends RePluginApplication {
    public static final String AF_KEY = "GFMADKCDDtzsUubS58QVGA";
    public static volatile HostApp instance;

    public static FireBase fireBase;
    public static Referrer mReferrer;

    public static String BR_ACTION = "ACTION";
    public static String ACTION_AF = "AppsFlyer";
    public static String ACTION_FB = "Firebase";
    public static String ACTION_RF = "Referrer";

    public static String KEY_APPSFLYERUID = "appsFlyerUID";
    public static String KEY_TOKEN = "token";
    public static String KEY_APPINSTANCEID = "appInstanceId";
    public static String KEY_REFERRER = "referrer";
    public static String KEY_APPINSTALLTIME = "appInstallTime";
    public static String KEY_INSTANTEXPERIENCELAUNCHED = "instantExperienceLaunched";


    public static HostApp getInstance() {
        if (instance == null) {
            synchronized (HostApp.class) {
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
        Log.e("xujm", "123");

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (TextUtils.equals(ProcessUtil.getCurrentProcessName(), getPackageName())) {
            init(this, AF_KEY);
            firebase(this);
            referrer(this);
        }
    }


    public static void referrer(Application context) {
        mReferrer = new Referrer("", "", false);
        GoogleInstallReferrer.installReferrer(context);
    }

    public void init(Application context, String af_dev_key) {
        Log.e("xujm", "AppsFlyer注册key:" + af_dev_key);
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {
                String appsFlyerUID = AppsFlyerLib.getInstance().getAppsFlyerUID(HostApp.getInstance());
                Log.e("xujm", "AppsFlyer初始化成功 appsFlyerUID:" + appsFlyerUID);

                Intent customIntent = new Intent();
                customIntent.setAction("com.paisa.home.action.AFRECEIVER");
                customIntent.putExtra(BR_ACTION, ACTION_AF);
                customIntent.putExtra(KEY_APPSFLYERUID, appsFlyerUID);
                sendBroadcast(customIntent);
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


    private void firebase(Application application) {
        FirebaseApp.initializeApp(application);

        final String[] token = {""};
        final String[] appInstanceId = {""};

        fireBase = new FireBase("", "");

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                token[0] = task.getResult();
                fireBase.setToken(token[0]);
                Log.e("xujm", "fireBase token---->" + token[0]);
            } else {
                fireBase.setToken("-1");
                Log.e("xujm", "token---->" + task.getException());
            }
            sendFireBase();
        });

        FirebaseAnalytics.getInstance(application).getAppInstanceId().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                appInstanceId[0] = task.getResult();
                fireBase.setAppInstanceId(appInstanceId[0]);
                Log.e("xujm", "fireBase appInstanceId---->" + appInstanceId[0]);
            } else {
                fireBase.setAppInstanceId("-1");
                Log.e("xujm", "appInstanceId---->" + task.getException());
            }
            sendFireBase();
        });
    }

    private void sendFireBase() {
        Log.e("xujm", "sendFireBase---->" + fireBase.toString());
        if (TextUtils.isEmpty(fireBase.getAppInstanceId()) || TextUtils.isEmpty(fireBase.getToken())) {
            return;
        }
        Intent customIntent = new Intent();
        customIntent.setAction("com.paisa.home.action.AFRECEIVER");
        customIntent.putExtra(BR_ACTION, ACTION_FB);
        customIntent.putExtra(KEY_TOKEN, fireBase.getToken());
        customIntent.putExtra(KEY_APPINSTANCEID, fireBase.getAppInstanceId());
        sendBroadcast(customIntent);
    }
}

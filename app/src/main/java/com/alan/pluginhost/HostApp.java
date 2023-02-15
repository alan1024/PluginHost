package com.alan.pluginhost;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.alan.pluginhost.google.GoogleInstallReferrer;
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
    public static final String AF_KEY = "9rUyyRzEAXJptHrBt3b4Xc";
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
        Log.e("xujm", "宿主初始化");

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.e("xujm", "宿主创建");
        if (isMainProcess()) {
            Log.e("xujm", "宿主当前进程SDK初始化");
            initReferrer(this);
            initAF(this, AF_KEY);
            initFirebase(this);
        }
    }

    /**
     * 初始化Referrer
     *
     * @param context
     */
    public static void initReferrer(Application context) {
        mReferrer = new Referrer("", "", false);
        GoogleInstallReferrer.installReferrer(context);
    }

    /**
     * 初始化AppsFlyer
     *
     * @param context
     */
    public void initAF(Application context, String af_dev_key) {
        Log.e("xujm", "AppsFlyer注册key:" + af_dev_key);
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {
                String appsFlyerUID = AppsFlyerLib.getInstance().getAppsFlyerUID(HostApp.getInstance());
                Log.e("xujm", "AppsFlyer初始化成功 appsFlyerUID:" + appsFlyerUID);

                Intent customIntent = new Intent();
                customIntent.setAction("com.rupee.park.action.AFRECEIVER");
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


    /**
     * 初始化Firebase
     *
     * @param application
     */
    private void initFirebase(Application application) {
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

    /**
     * 发送FireBase
     */
    private void sendFireBase() {
        Log.e("xujm", "sendFireBase---->" + fireBase.toString());
        if (TextUtils.isEmpty(fireBase.getAppInstanceId()) || TextUtils.isEmpty(fireBase.getToken())) {
            return;
        }
        Intent customIntent = new Intent();
        customIntent.setAction("com.rupee.park.action.AFRECEIVER");
        customIntent.putExtra(BR_ACTION, ACTION_FB);
        customIntent.putExtra(KEY_TOKEN, fireBase.getToken());
        customIntent.putExtra(KEY_APPINSTANCEID, fireBase.getAppInstanceId());
        sendBroadcast(customIntent);
    }

    /**
     * 获取进程号对应的进程名
     *
     * @return 进程名
     */
    private boolean isMainProcess() {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager mActivityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                processName = appProcess.processName;
                break;
            }
        }
        String packageName = this.getPackageName();
        if (processName.equals(packageName)) {
            return true;
        }
        return false;
    }

}

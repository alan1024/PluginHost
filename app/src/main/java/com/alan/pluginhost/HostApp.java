package com.alan.pluginhost;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.qihoo360.replugin.RePluginApplication;

import org.json.JSONObject;

import java.util.Map;

public class HostApp extends RePluginApplication {
    public static final String AF_KEY = "kaiXeo97irmWLBhAjKhvya";
    public static String AF_ID = "af_id";
    public static String AF_CONVERSION_KEY = "conversion_data";
    public static String AF_MEDIA = "media_source_key";

    private static volatile HostApp instance;

    public static HostApp getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e("xujm", "应用启动");

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (isMain()) {
            Log.e("xujm", "开始主进程初始化");
            init(this, AF_KEY);
        }
    }

    //app name：Rocket Loan
    //package：com.rocket.loan.uang
    //af key：kaiXeo97irmWLBhAjKhvya
    public void init(Application context, String af_dev_key) {
        Log.e("xujm", "AppsFlyer注册key:" + af_dev_key);
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                Log.e("xujm", "AppsFlyer初始化成功");
                String afId = AppsFlyerLib.getInstance().getAppsFlyerUID(context);
                String afMedia = "";
                String afConversion = "";

                if (map != null) {
                    JSONObject conversionData = new JSONObject(map);
                    afConversion = conversionData.toString();
                    for (String key : map.keySet()) {
                        if (key.equals("media_source")) {
                            //本地保存MediaSource，发埋点
                            afMedia = map.get(key).toString();
                        }
                    }
                }

                Log.e("xujm", "AppsFlyer初始化成功afId:" + afId);
                Log.e("xujm", "AppsFlyer初始化成功afMedia:" + afMedia);
                Log.e("xujm", "AppsFlyer初始化成功afConversion:" + afConversion);

                Intent customIntent = new Intent();
                customIntent.setAction("com.rocket.loan.uang.action.AFRECEIVER");
                customIntent.putExtra(AF_ID, afId);
                customIntent.putExtra(AF_MEDIA, afMedia);
                customIntent.putExtra(AF_CONVERSION_KEY, afConversion);
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

    private boolean isMain() {
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

package com.alan.pluginhost;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.multidex.MultiDex;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.OnAttributionChangedListener;
import com.qihoo360.replugin.RePluginApplication;

public class HostApp extends RePluginApplication {
    public static final String AF_KEY = "BjbZ8Y5WdjqF9Vu7mxYqeW";
    public static final String ADJUSTKEY = "hfalivn2mmm8";
    private String GOOGLEADID = "googleadid";
    private String CHANNEL = "channel";
    private String mGoogleAdId;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e("xujm", "宿主启动");

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (!isMain()) {
            return;
        }
        Log.e("xujm", "宿主onCreate");
        initAdJust();
    }

    private void initAdJust() {
        AdjustConfig config = new AdjustConfig(this, ADJUSTKEY, AdjustConfig.ENVIRONMENT_PRODUCTION);
        config.setUrlStrategy(AdjustConfig.URL_STRATEGY_CHINA);
        Adjust.onCreate(config);
        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());
        config.setOnAttributionChangedListener(new OnAttributionChangedListener() {
            @Override
            public void onAttributionChanged(AdjustAttribution attribution) {
                Log.e("xujm", "====channel:" + attribution.network);
                Intent customIntent = new Intent();
                customIntent.setAction("com.rocket.loan.uang.action.AFRECEIVER");
                customIntent.putExtra(GOOGLEADID, mGoogleAdId);
                customIntent.putExtra(CHANNEL, attribution.network);
                sendBroadcast(customIntent);
            }
        });
        Adjust.getGoogleAdId(this, googleAdId -> {
            Log.e("xujm", "====googleAdId:" + googleAdId);
            mGoogleAdId = googleAdId;
        });
    }

    /**
     * 是否是主线程
     */
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

    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    }


//    public void init(Application context, String af_dev_key) {
//        Log.e("xujm", "AppsFlyer注册key:" + af_dev_key);
//        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
//            @Override
//            public void onConversionDataSuccess(Map<String, Object> conversionData) {
//                Log.e("xujm", "AppsFlyer初始化成功");
//            }
//
//            @Override
//            public void onConversionDataFail(String errorMessage) {
//                Log.e("xujm", "AppsFlyer初始化失败" + errorMessage);
//            }
//
//            @Override
//            public void onAppOpenAttribution(Map<String, String> conversionData) {
//                Log.e("xujm", "AppsFlyer属性成功：" + conversionData.toString());
//
//            }
//
//            @Override
//            public void onAttributionFailure(String errorMessage) {
//                Log.e("xujm", "AppsFlyer属性失败：" + errorMessage);
//            }
//        };
//        AppsFlyerLib.getInstance().init(af_dev_key, conversionListener, context);
//        AppsFlyerLib.getInstance().setDebugLog(true);
//        AppsFlyerLib.getInstance().start(context);
//    }


}

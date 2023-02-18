package com.alan.pluginhost.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.view.View;

import com.alan.pluginhost.HostApp;
import com.alan.pluginhost.async.ThreadPoolUtils;

import java.util.concurrent.ExecutorService;

public class UIUtils {

    public static Context getContext() {
        return HostApp.getInstance();
    }

    public static Handler getHandler() {
        return null;
    }

    //返回指定colorId对应的颜色值
    public static int getColor(int colorId) {
        return getContext().getResources().getColor(colorId);
    }

    //加载指定viewId的视图对象，并返回
    public static View getView(int viewId) {
        View view = View.inflate(getContext(), viewId, null);
        return view;
    }

    public static String[] getStringArr(int strArrId) {
        String[] stringArray = getContext().getResources().getStringArray(strArrId);
        return stringArray;
    }

    //将dp转化为px
    public static int dp2px(int dp) {
        //获取手机密度
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);//实现四舍五入
    }

    public static int px2dp(int px) {
        //获取手机密度
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);//实现四舍五入
    }

    /**
     * 保证运行在主线程
     */
    public static void runOnUiThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            UIUtils.getHandler().post(runnable);
        }
    }

    //判断当前线程是否是主线程
    private static boolean isMainThread() {
        int currentThread = Process.myTid();

        return false;
    }

    private static ExecutorService sExecutorService;

    public static void setExecutorService(ExecutorService executorService) {
        sExecutorService = executorService;
    }

    public static void exectur(Runnable runnable) {
        //如果外部库不为空，则使用外部，否则使用自己的
        if (sExecutorService != null) {
            sExecutorService.execute(runnable);
        } else {
            ThreadPoolUtils.getService().execute(runnable);
        }
    }
}

package com.alan.pluginhost.utils;

import android.os.Handler;
import android.os.Looper;


public class OkhttpManager {
    private static final String FILE_PREFIX = "CNIAO5_";
    //OKhttp对象实例
    private static OkhttpManager okhttpManager;
    private Handler handler;

    private static OkhttpManager getInstance() {
        if (okhttpManager == null) {
            okhttpManager = new OkhttpManager();
        }
        return okhttpManager;
    }

    private OkhttpManager() {
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * 根据文件URL地址获取文件的路径文件名
     *
     * @param pUrl
     * @return
     */
    private String getFileName(String pUrl) {
        int separatorIndex = pUrl.lastIndexOf("/");
        String path = (separatorIndex < 0) ? pUrl : pUrl.substring(separatorIndex + 1, pUrl.length());
        return FILE_PREFIX + path;
    }

    private void deliverFailure() {

    }

    /**
     * 请求分发请求成功的数据情况
     *
     * @param result
     * @param callBack
     */
    private void deliverSuccess(final String result, final DataCallBack callBack) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.requestSuccess(result);
                }
            }
        });
    }


    //*************数据回调接口************************
    public interface DataCallBack {

        /**
         * 请求成功
         *
         * @param result
         */
        void requestSuccess(String result);
    }
}

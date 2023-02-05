package com.alan.pluginhost.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.alan.pluginhost.HostApp;
import com.alan.pluginhost.R;
import com.alan.pluginhost.http.ProgressHelper;
import com.alan.pluginhost.http.UIProgressResponseListener;
import com.alan.pluginhost.listener.DownloadResultListener;
import com.alan.pluginhost.utils.LogUtils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class DownloadServer extends Service {

    private static final String TAG = "DownloadServer";

    private DownloadBinder serviceBinder = new DownloadBinder();

    private HostApp app;

    @Override
    public IBinder onBind(Intent intent) {
        return serviceBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = HostApp.getInstance();
    }

    public void download(String url, String name, DownloadResultListener listener) {
        if (listener != null) {
            listener.onStart();
        }

        final UIProgressResponseListener progressResponseListener = new UIProgressResponseListener() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                int progress = (int) ((100 * bytesRead) / contentLength);
                LogUtils.d(TAG, "progress: " + progress);
                if (listener != null) {
                    listener.onProgress(progress);
                }
            }
        };

        // Request
        final Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        ProgressHelper.addProgressResponseListener(okHttpClient, progressResponseListener).newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                LogUtils.e(TAG, getString(R.string.error), e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (listener != null) {
                    listener.onEnd();
                }
            }
        });
    }


    /**
     *
     */
    public class DownloadBinder extends Binder {

        DownloadServer getServer() {
            return DownloadServer.this;
        }
    }
}

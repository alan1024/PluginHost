package com.alan.pluginhost.server;


import androidx.annotation.NonNull;

import com.alan.pluginhost.HostApp;
import com.alan.pluginhost.common.BizInterface;
import com.alan.pluginhost.utils.NetUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    //设缓存有效期为两天
    protected static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    protected static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置，头部Cache-Control设为max-age=0时则不会使用缓存而请求服务器
    protected static final String CACHE_CONTROL_NETWORK = "max-age=0";

    private volatile static OkHttpClient mOkHttpClient;

    private volatile static AllAPI mAPI = null;

    private RetrofitService() {
    }

    private volatile static RetrofitService instance = null;

    public static RetrofitService getInstance() {
        if (instance == null) {
            synchronized (RetrofitService.class) {
                if (instance == null) {
                    instance = new RetrofitService();
                }
            }
        }
        return instance;
    }

    /**
     * 创建api
     */
    public AllAPI createAPI() {
        initOkHttpClient();
        if (mAPI == null) {
            mAPI = new Retrofit.Builder()
                    .client(mOkHttpClient)
                    .baseUrl(BizInterface.SHOW_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build().create(AllAPI.class);
        }
        return mAPI;
    }

    // 配置OkHttpClient
    private static void initOkHttpClient() {
        if (mOkHttpClient == null) {
            // 因为BaseUrl不同所以这里Retrofit不为静态，但是OkHttpClient配置是一样的,静态创建一次即可
            File cacheFile = new File(HostApp.newInstance().getCacheDir(),
                    "HttpCache"); // 指定缓存路径
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); // 指定缓存大小100Mb
            // 云端响应头拦截器，用来配置缓存策略
            Interceptor rewriteCacheControlInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!NetUtil.isConnected(HostApp.newInstance().getApplicationContext())) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE).build();
                    }
                    Response originalResponse = chain.proceed(request);
                    if (NetUtil.isConnected(HostApp.newInstance())) {
                        //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                        String cacheControl = request.cacheControl().toString();
                        return originalResponse.newBuilder()
                                .header("Cache-Control", cacheControl)
                                .removeHeader("Pragma").build();
                    } else {
                        return originalResponse.newBuilder().header("Cache-Control",
                                        "public, only-if-cached," + CACHE_STALE_SEC)
                                .removeHeader("Pragma").build();
                    }
                }
            };
//            mOkHttpClient = new OkHttpClient();
//            mOkHttpClient.setCache(cache);
//            mOkHttpClient.networkInterceptors().add(rewriteCacheControlInterceptor);
//            mOkHttpClient.interceptors().add(rewriteCacheControlInterceptor);
//            mOkHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);

            //okhttp 3
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder().cache(cache)
                    .addNetworkInterceptor(rewriteCacheControlInterceptor)
                    .addInterceptor(rewriteCacheControlInterceptor)
                    .addInterceptor(logInterceptor)
                    .connectTimeout(10, TimeUnit.SECONDS);
            mOkHttpClient = builder.build();

        }
    }

    /**
     * 根据网络状况获取缓存的策略
     *
     * @return
     */
    @NonNull
    public static String getCacheControl() {
        return NetUtil.isConnected(HostApp.newInstance()) ? CACHE_CONTROL_NETWORK : CACHE_CONTROL_CACHE;
    }
}

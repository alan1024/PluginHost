package com.alan.pluginhost.network;

import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class NetworkResolver {
    public static void getResponse(String url, Map<String, String> params, final Callback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        LoadService service = retrofit.create(LoadService.class);
//        service.loadNews(params)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<WeatherBean>(){
//
//                    @Override
//                    public void onSubscribe(Subscription s) {
//
//                    }
//
//                    @Override
//                    public void onNext(WeatherBean weatherBean) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    public static abstract class Callback {
        public abstract void onSuccess(Object object);

        public abstract void onFailure(Throwable e);
    }
}

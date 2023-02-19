package com.alan.pluginhost.network;

import com.alan.pluginhost.beans.WeatherBeanPackage.WeatherBean;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;


public interface LoadService {
    @GET("query")
    Observable<WeatherBean> loadNews(@QueryMap Map<String, String> otions);
}

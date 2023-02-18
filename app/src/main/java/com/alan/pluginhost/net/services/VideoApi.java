package com.alan.pluginhost.net.services;

import com.alan.pluginhost.bean.video.VideoPageData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface VideoApi {
    @GET("0-{page}.json")
    Observable<VideoPageData> getVideoData(@Path("page") int page, @Query("market") String market, @Query("udid") String udid,
                                           @Query("appname") String appname, @Query("os") String os,
                                           @Query("client") String client, @Query("visiting") String visiting,
                                           @Query("mac") String mac, @Query("ver") String ver);
}

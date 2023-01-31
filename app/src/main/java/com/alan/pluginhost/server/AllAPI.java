package com.alan.pluginhost.server;

import com.alan.pluginhost.common.BizInterface;
import com.alan.pluginhost.model.entity.OpenApiPicture;
import com.alan.pluginhost.model.entity.OpenApiResponse;
import com.alan.pluginhost.model.entity.OpenApiWeather;
import com.alan.pluginhost.model.entity.ShowApiNews;
import com.alan.pluginhost.model.entity.ShowApiPictures;
import com.alan.pluginhost.model.entity.ShowApiResponse;
import com.alan.pluginhost.model.entity.ShowApiWeather;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AllAPI {
    /**
     * 新闻列表
     *
     * @param cacheControl 缓存控制
     * @param appId        易源appid
     * @param key          易源密钥
     * @param page         页数
     * @param channelId    频道id
     * @param channelName  名称
     * @return
     */
    @GET(BizInterface.NEWS_URL)
    @Headers({"apikey: " + BizInterface.API_KEY, BizInterface.DOMAIN + BizInterface.DOMAIN_SHOW_API})
    Call<ShowApiResponse<ShowApiNews>> getNewsList(@Header("Cache-Control") String cacheControl,
                                                   @Query("showapi_appid") String appId,
                                                   @Query("showapi_sign") String key,
                                                   @Query("page") int page,
                                                   @Query("channelId") String channelId,//新闻频道id，必须精确匹配
                                                   @Query("channelName") String channelName);//新闻频道名称，可模糊匹配


    /**
     * 美图大全
     *
     * @param page  页数
     * @param count 每页请求数目
     * @return
     */
    @Headers({BizInterface.DOMAIN + BizInterface.DOMAIN_OPEN_API})
    @FormUrlEncoded
    @POST(BizInterface.OPEN_API_PICTURES_URL)
    Observable<OpenApiResponse<List<OpenApiPicture>>> getPictures(@Header("Cache-Control") String cacheControl,
                                                                  @Field("page") int page,
                                                                  @Field("count") int count);

    /**
     * 易源美图大全
     *
     * @return
     */
    @GET(BizInterface.PICTURES_URL)
    @Headers({"apikey: " + BizInterface.API_KEY, BizInterface.DOMAIN + BizInterface.DOMAIN_SHOW_API})
    Observable<ShowApiResponse<ShowApiPictures>> getShowApiPictures(@Header("Cache-Control") String cacheControl,
                                                                    @Query("showapi_appid") String appId,
                                                                    @Query("showapi_sign") String key,
                                                                    @Query("type") String type,
                                                                    @Query("page") int count);

    /**
     * 天气预报
     *
     * @param area             地区名称，比如北京
     * @param needMoreDay      是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @param needIndex        是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needAlarm        是否需要天气预警。1为需要，0为不需要。
     * @param need3HourForcast 是否需要当天每3小时1次的天气预报列表。1为需要，0为不需要。
     * @return
     */
    @GET(BizInterface.WEATHER_URL)
    @Headers("apikey: " + BizInterface.API_KEY)
    Observable<ShowApiResponse<ShowApiWeather>> getWeather(@Header("Cache-Control") String cacheControl,
                                                           @Query("area") String area,
                                                           @Query("needMoreDay") String needMoreDay,
                                                           @Query("needIndex") String needIndex,
                                                           @Query("needAlarm") String needAlarm,
                                                           @Query("need3HourForcast") String need3HourForcast);

    @Headers({BizInterface.DOMAIN + BizInterface.DOMAIN_OPEN_API})
    @FormUrlEncoded
    @POST(BizInterface.OPEN_API_WEATHER_URL)
    Observable<OpenApiResponse<OpenApiWeather>> getWeather(@Header("Cache-Control") String cacheControl,
                                                           @Field("city") String city);
}

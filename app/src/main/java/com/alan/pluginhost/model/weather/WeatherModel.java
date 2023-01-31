package com.alan.pluginhost.model.weather;


import com.alan.pluginhost.model.OnNetRequestListener;
import com.alan.pluginhost.model.entity.OpenApiResponse;
import com.alan.pluginhost.model.entity.OpenApiWeather;
import com.alan.pluginhost.model.entity.ShowApiWeather;

import io.reactivex.rxjava3.core.Observable;

public interface WeatherModel {
    /**
     * 获取天气预报
     *
     * @param area             地区名称，比如北京
     * @param needMoreDay      是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @param needIndex        是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needAlarm        是否需要天气预警。1为需要，0为不需要。
     * @param need3HourForcast 是否需要当天每3小时1次的天气预报列表。1为需要，0为不需要。
     * @param listener         网络请求成功失败监听
     */
    void netLoadWeatherWithLocation(String area, String needMoreDay, String needIndex, String needAlarm,
                                    String need3HourForcast, OnNetRequestListener<ShowApiWeather> listener);

    /**
     * 获取天气预报 openapi
     *
     * @param cityName
     */
    Observable<OpenApiResponse<OpenApiWeather>> netGetWeather(String cityName);
}

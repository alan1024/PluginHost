package com.alan.pluginhost.model.weather;

import com.alan.pluginhost.model.OnNetRequestListener;
import com.alan.pluginhost.model.entity.OpenApiResponse;
import com.alan.pluginhost.model.entity.OpenApiWeather;
import com.alan.pluginhost.model.entity.ShowApiResponse;
import com.alan.pluginhost.model.entity.ShowApiWeather;
import com.alan.pluginhost.server.RetrofitService;

import io.reactivex.rxjava3.core.Observable;


public class WeatherModelImpl implements WeatherModel {
    @Override
    public void netLoadWeatherWithLocation(String area, String needMoreDay, String needIndex,
                                           String needAlarm, String need3HourForcast,
                                           final OnNetRequestListener listener) {
        //使用RxJava响应Retrofit
        Observable<ShowApiResponse<ShowApiWeather>> observable = RetrofitService.getInstance().
                createAPI().getWeather(RetrofitService.getCacheControl(), area, needMoreDay,
                        needIndex, needAlarm, need3HourForcast);


    }

    @Override
    public Observable<OpenApiResponse<OpenApiWeather>> netGetWeather(String cityName) {
        //临时切换baseurl
        return RetrofitService.getInstance().
                createAPI().getWeather(RetrofitService.getCacheControl(), cityName);
    }
}

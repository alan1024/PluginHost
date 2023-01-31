package com.alan.pluginhost.adapter;


import androidx.annotation.Nullable;

import com.alan.pluginhost.R;
import com.alan.pluginhost.model.entity.OpenApiWeather;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;


public class WeatherAdapter extends BaseQuickAdapter<OpenApiWeather.ForecastBean, BaseViewHolder> {
    public WeatherAdapter(@Nullable List<OpenApiWeather.ForecastBean> data) {
        super(R.layout.item_weather_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OpenApiWeather.ForecastBean item) {
        helper.setText(R.id.tv_date, item.getDate());
        helper.setText(R.id.tv_type, item.getType());
        helper.setText(R.id.tv_temperature_high, item.getHigh());
        helper.setText(R.id.tv_temperature_low, item.getLow());
        helper.setText(R.id.tv_wind_direction, item.getFengxiang());
    }
}

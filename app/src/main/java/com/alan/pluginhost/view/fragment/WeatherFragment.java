package com.alan.pluginhost.view.fragment;

import android.text.TextUtils;
import android.view.View;

import com.alan.pluginhost.R;
import com.alan.pluginhost.adapter.WeatherAdapter;
import com.alan.pluginhost.delegate.WeatherFragmentDelegate;
import com.alan.pluginhost.model.entity.OpenApiWeather;
import com.alan.pluginhost.model.weather.WeatherModel;
import com.alan.pluginhost.model.weather.WeatherModelImpl;
import com.alan.pluginhost.mvp_frame.presenter.FragmentPresenter;

import java.util.ArrayList;
import java.util.List;


public class WeatherFragment extends FragmentPresenter<WeatherFragmentDelegate> implements View.OnClickListener {
    public static final String NEED_MORE_DAY = "1";
    public static final String NEED_INDEX = "1";
    public static final String NEED_ALARM = "1";
    public static final String NEED_3_HOUR_FORCAST = "1";

    private WeatherModel mWeatherModel;

    private List<OpenApiWeather.ForecastBean> mForecastBeans = new ArrayList<>();
    private WeatherAdapter mWeatherAdapter;

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        return fragment;
    }

    @Override
    protected Class<WeatherFragmentDelegate> getDelegateClass() {
        return WeatherFragmentDelegate.class;
    }

    @Override
    protected void initData() {
        super.initData();
        mWeatherModel = new WeatherModelImpl();
        mWeatherAdapter = new WeatherAdapter(mForecastBeans);
        viewDelegate.initRecyclerView(mWeatherAdapter);
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(this, R.id.bt_weather);
    }

    /**
     * 获取天气预报
     */
    private void netWeather() {
        if (TextUtils.isEmpty(viewDelegate.getInputLocation())) {
            viewDelegate.showSnackbar("输入为空");
            return;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_weather:
                netWeather();
                break;
        }
    }
}

package com.alan.pluginhost.mvp.presenter;

import com.alan.pluginhost.base.BasePresenter;

public abstract  class MonthChartPresenter extends BasePresenter {

    public abstract void getMonthChartBills(int id,String year,String month);
}

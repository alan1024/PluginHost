package com.alan.pluginhost.mvp.presenter;


import com.alan.pluginhost.base.BasePresenter;

public abstract  class MonthAccountPresenter extends BasePresenter {

    public abstract void getMonthAccountBills(int id,String year,String month);
}

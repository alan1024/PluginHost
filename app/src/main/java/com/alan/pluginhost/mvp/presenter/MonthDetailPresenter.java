package com.alan.pluginhost.mvp.presenter;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.model.bean.local.BBill;

public abstract  class MonthDetailPresenter extends BasePresenter {

    public abstract void getMonthDetailBills(int id,String year,String month);

    public abstract void deleteBill(Long id);

    public abstract void updateBill(BBill bBill);
}

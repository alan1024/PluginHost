package com.alan.pluginhost.mvp.model;

import com.alan.pluginhost.model.bean.local.BBill;

public interface MonthDetailModel {

    /**
     * 每月账单详情
     */
    void getMonthDetailBills(int id, String year, String month);

    /**
     * 删除账单
     */
    void delete(Long id);

    void update(BBill bBill);

    void onUnsubscribe();
}

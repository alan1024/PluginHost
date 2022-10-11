package com.alan.pluginhost.mvp.view;

import com.alan.pluginhost.base.BaseView;
import com.alan.pluginhost.model.bean.BaseBean;
import com.alan.pluginhost.model.bean.local.MonthDetailBean;

public interface MonthDetailView extends BaseView<MonthDetailBean>{

    /**
     * 本地当月账单
     * @param list
     */
    void loadDataSuccess(MonthDetailBean list);
    /**
     * 删除成功
     * @param tData
     */
    void loadDataSuccess(BaseBean tData);
}

package com.alan.pluginhost.ui.contract;

import com.alan.pluginhost.base.BaseContract;
import com.alan.pluginhost.bean.daily.DailyTimeLine;

public class DailyContract {
    public interface View extends BaseContract.BaseView {
        void disPlayDailyTimeLine(DailyTimeLine dailyTimeLine);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getDailyTimeLine(String num);
    }
}

package com.alan.pluginhost.ui.contract;

import android.content.Context;

import com.alan.pluginhost.base.BaseContract;
import com.alan.pluginhost.bean.zhihu.NewsTimeLine;

public class ZhiHuContract {
    public interface View extends BaseContract.BaseView {
        void disPlayZhihuList(NewsTimeLine newsTimeLine, Context context);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getBeforeNews(String time);

        void getLatestNews();
    }
}

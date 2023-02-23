package com.alan.pluginhost.modules.zhihu.home.mvp;

import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;


interface ZhiHuHomeContract {
    interface View extends ImpBaseView {
        void showRefreshBar();

        void hideRefreshBar();

        void refreshData();

        void refreshSuccessed(ZhiHuDaily stories);

        void refreshFail(String errMsg);

        void loadMoreData();

        void loadSuccessed(ArrayList<BaseItem> stories);

        void loadFail(String errMsg);
    }

    interface Presenter extends ImpBasePresenter {
        void refreshZhihuDaily();

        void loadMoreData();

        void loadCache();
    }
}

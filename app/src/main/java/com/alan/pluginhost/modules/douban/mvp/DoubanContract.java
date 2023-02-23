package com.alan.pluginhost.modules.douban.mvp;


import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;

public interface DoubanContract {
    interface View extends ImpBaseView {
        void showProgressBar();

        void hideProgressBar();

        void loadMoreData();

        void refreshData();

        void loadSuccessed(ArrayList<BaseItem> movieSubjects);

        void loadFail(String errMsg);

        void refreshSucceed(ArrayList<BaseItem> movieSubjects);

        void refreshFail(String errMsg);
    }

    interface Presenter extends ImpBasePresenter {
        void refreshData();

        void loadMoreData();

        void loadCache();
    }
}

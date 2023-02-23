package com.alan.pluginhost.modules.news;

import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;

public interface NewsContract {
    interface View extends ImpBaseView {
        void showRefreshBar();

        void hideRefreshBar();

        void refreshNews();

        void refreshNewsFail(String errorMsg);

        void refreshNewsSuccessed(ArrayList<BaseItem> topNews);

        void loadMoreNews();

        void loadMoreFail(String errorMsg);

        void loadMoreSuccessed(ArrayList<BaseItem> topNewses);

        void loadAll();
    }

    interface Presenter extends ImpBasePresenter {
        void refreshNews();

        void loadMore();

        void loadCache();
    }
}

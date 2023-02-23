package com.alan.pluginhost.modules.news.newsdetail;

import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

interface NewsDetailContract {
    interface View extends ImpBaseView {
        void showProgressBar();

        void hideProgressBar();

        void loadTopNewsInfo(String newsId);

        void loadFail(String errmsg);

        void loadSuccess(NewsContent topNewsContent);

    }

    interface Presenter extends ImpBasePresenter {
        void loadNewsContent(final String id);
    }
}

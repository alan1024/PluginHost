package com.alan.pluginhost.modules.video.videohome.mvp;

import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;

interface VideoHomeContract {
    interface View extends ImpBaseView {
        void refreshData();

        void refreshSuccess(ArrayList<RetDataBean.ListBean> listBeen);

        void refreshFail(String errCode, String errMsg);

        void showProgressBar();

        void hideProgressBar();
    }

    interface Presenter extends ImpBasePresenter {
        void loadData();

        void loadCache();
    }
}

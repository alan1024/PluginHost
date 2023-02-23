package com.alan.pluginhost.modules.video.videodetail.mvp;

import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


public interface VideoInfoContract {
    interface View extends ImpBaseView {
        void loadInfo();

        String getDataId();

        void loadInfoFail(String errCode, String errMsg);

        void loadInfoSuccess(MovieInfo movieInfo);
    }

    interface Presenter extends ImpBasePresenter {
        void loadVideoInfo();
    }
}

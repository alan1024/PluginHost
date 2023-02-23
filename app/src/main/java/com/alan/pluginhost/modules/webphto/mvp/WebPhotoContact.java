package com.alan.pluginhost.modules.webphto.mvp;

import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


interface WebPhotoContact {
    interface View extends ImpBaseView {
        void savePicSuccess(String path);

        void savePicFail(String msg);
    }

    interface Presenter extends ImpBasePresenter {
        void savePic(String url);
    }
}

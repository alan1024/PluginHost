package com.alan.pluginhost.modules.setting.aboutme;

import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


interface AboutMeContract {
    interface View extends ImpBaseView {
        void loadMyInfo();

        void showMyInfo(UserInfo myInfo);

        void loadMyInfoFail();
    }

    interface Presenter extends ImpBasePresenter {
        void loadInfo(String user);
    }
}

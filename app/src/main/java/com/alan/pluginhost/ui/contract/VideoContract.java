package com.alan.pluginhost.ui.contract;

import com.alan.pluginhost.base.BaseContract;
import com.alan.pluginhost.bean.video.VideoPageData;


public class VideoContract {
    public interface View extends BaseContract.BaseView {
        void displayVideo(VideoPageData videoPageData);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getVideoData();
    }
}

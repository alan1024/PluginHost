package com.alan.pluginhost.modules.video.videodetail.mvp;

import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


class VideoInfoFragPresenter extends BasePresenter implements VideoInfoContract.Presenter {
    private VideoInfoContract.View mVideoInfoFrag;

    /**
     * 获取视频详情页
     */
    @Override
    public void loadVideoInfo() {

    }

    @Override
    public void bindView(ImpBaseView view) {
        mVideoInfoFrag = (VideoInfoContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mVideoInfoFrag = null;
    }
}

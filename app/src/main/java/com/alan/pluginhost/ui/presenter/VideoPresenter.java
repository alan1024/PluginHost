package com.alan.pluginhost.ui.presenter;

import android.content.Context;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.VideoContract;
import com.alan.pluginhost.ui.contract.VideoContract.Presenter;


public class VideoPresenter extends BasePresenter<VideoContract.View> implements Presenter {

    private int page = 20;

    private Context mContext;

    public VideoPresenter(@ContextLife Context context) {
        mContext = context;
    }

    @Override
    public void getVideoData() {
        if (mView != null) {
            mView.showLoading();
//            RetrofitManager.createVideoIo(VideoApi.class)
//                    .getVideoData(page, "baidu", "863425026599592", "baisibudejie",
//                            "5.1.1", "android", "", "862720032545006&mac=20%3A5d%3A47%3A82%3Ae2%3A7e", "7.0.8")
//                    .compose(RxSchedulers.applySchedulers())
//                    .compose(mView.bindToLife())
//                    .subscribe(videoPageData -> {
//                        mView.displayVideo(videoPageData);
//                    }, this::loadError);
        }
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        mView.hideLoading();
    }
}

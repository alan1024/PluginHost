package com.alan.pluginhost.ui.presenter;

import android.content.Context;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.bean.gank.Gank;
import com.alan.pluginhost.bean.gank.Meizhi;
import com.alan.pluginhost.bean.gank.Video;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.GankContract;
import com.alan.pluginhost.utils.DateUtils;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class GankPresenter extends BasePresenter<GankContract.View> implements GankContract.Presenter {
    private Context mContext;

    @Inject
    public GankPresenter(@ContextLife Context context) {
        this.mContext = context;
    }

    @Override
    public void getGankData(int pageNum) {
        if (mView != null) {
            mView.showLoading();
//            GankApi gankApi = RetrofitManager.createGankIo(GankApi.class);
//            Observable.zip(gankApi.getMeizhiData(pageNum)
//                    , gankApi.getVideoData(pageNum), this::creatDesc)
//                    .compose(mView.bindToLife())
//                    .compose(RxSchedulers.applySchedulers())
//                    .subscribe(meizhi1 -> {
//                        mView.displayMeizhi( meizhi1.getResults());
//                    }, this::loadError);
        }
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        mView.hideLoading();
    }


    private Meizhi creatDesc(Meizhi meizhi, Video video) {
        for (Gank gankmeizhi : meizhi.getResults()) {
            gankmeizhi.desc = gankmeizhi.desc + " " +
                    getVideoDesc(gankmeizhi.getPublishedAt(), video.getResults());
        }
        return meizhi;
    }

    //匹配同一天的福利描述和视频描述
    private String getVideoDesc(Date publishedAt, List<Gank> results) {
        String videoDesc = "";
        for (int i = 0; i < results.size(); i++) {
            Gank video = results.get(i);
            if (video.getPublishedAt() == null) video.setPublishedAt(video.getCreatedAt());
            if (DateUtils.isSameDate(publishedAt, video.getPublishedAt())) {
                videoDesc = video.getDesc();
                break;
            }
        }
        return videoDesc;
    }


}

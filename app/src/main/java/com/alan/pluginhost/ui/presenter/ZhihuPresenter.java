package com.alan.pluginhost.ui.presenter;

import android.content.Context;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.ZhiHuContract;

import javax.inject.Inject;


public class ZhihuPresenter extends BasePresenter<ZhiHuContract.View> implements ZhiHuContract.Presenter {

    private Context mContext;


    @Inject
    public ZhihuPresenter(@ContextLife Context context) {
        this.mContext = context;
    }

    @Override
    public void getBeforeNews(String time) {
        if (mView != null) {
            mView.showLoading();
//            RetrofitManager.createZhiHuIo(ZhihuApi.class).getBeforetNews(time)
//                    .compose(mView.bindToLife())
//                    .compose(RxSchedulers.<NewsTimeLine>applySchedulers())
//                    .subscribe(newsTimeLine -> {
//                       mView.disPlayZhihuList(newsTimeLine, mContext);
//                    }, this::loadError);
        }
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();

        mView.showFaild(throwable.getMessage());
    }


    @Override
    public void getLatestNews() {
        if (mView != null) {
            mView.showLoading();

//            RetrofitManager.createZhiHuIo(ZhihuApi.class)
//                    .getLatestNews()
//                    .compose(mView.bindToLife())
//                    .compose(RxSchedulers.applySchedulers())
//                    .subscribe(newsTimeLine -> {
//                        mView.disPlayZhihuList(newsTimeLine, mContext);
//                    }, this::loadError);
        }
    }


}

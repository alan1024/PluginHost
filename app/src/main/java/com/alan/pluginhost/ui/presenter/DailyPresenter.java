package com.alan.pluginhost.ui.presenter;

import android.content.Context;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.DailyContract;

import javax.inject.Inject;

public class DailyPresenter extends BasePresenter<DailyContract.View> implements DailyContract.Presenter {
    private Context mContext;

    @Inject
    public DailyPresenter(@ContextLife Context context) {
        this.mContext = context;
    }

    @Override
    public void getDailyTimeLine(String num) {
        if (mView != null) {
            mView.showLoading();
//            RetrofitManager.createDailyIo(DailyApi.class)
//                    .getDailyTimeLine(num)
//                    .compose(mView.bindToLife())
//                    .compose(RxSchedulers.applySchedulers())
//                    .subscribe(dailyTimeLine -> {
//
//                    }, this::loadError);
        }
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        mView.hideLoading();
    }

}

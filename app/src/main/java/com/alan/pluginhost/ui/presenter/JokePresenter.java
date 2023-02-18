package com.alan.pluginhost.ui.presenter;

import android.content.Context;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.JokeContract;

import javax.inject.Inject;


public class JokePresenter extends BasePresenter<JokeContract.View> implements JokeContract.Presenter {
    public final String Type_JOKE = "jandan.get_duan_comments";


    private Context mContext;

    @Inject
    public JokePresenter(@ContextLife Context context) {
        mContext = context;
    }

    @Override
    public void getDetailData(int page) {
        if (mView != null) {
            mView.showLoading();
//            RetrofitManager.createJokeIo(JokeApi.class)
//                    .getDetailData(Type_JOKE, page)
//                    .compose(RxSchedulers.applySchedulers())
//                    .compose(mView.bindToLife())
//                    .subscribe(jokeBean -> {
//                        mView.displayJokeList(jokeBean);
//                    }, this::loadError);
        }
    }


    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        mView.hideLoading();
    }

}

package com.alan.pluginhost.modules.setting.aboutme;

import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

class AboutMePresenter extends BasePresenter implements AboutMeContract.Presenter {
    private AboutMeContract.View mActivity;

    @Override
    public void loadInfo(String user) {
//        ApiManager.getInstence()
//                .getGithubService()
//                .getMyInfo(user)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<UserInfo>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(UserInfo value) {
//                        mActivity.showMyInfo(value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mActivity.loadMyInfoFail();
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public void bindView(ImpBaseView view) {
        mActivity = (AboutMeContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mActivity = null;
    }
}

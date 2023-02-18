package com.alan.pluginhost.ui.presenter;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.ui.contract.RegisterActivityContract;

import javax.inject.Inject;

public class RegisterActivityImp extends BasePresenter<RegisterActivityContract.View> implements RegisterActivityContract.Presenter {
    @Inject
    public RegisterActivityImp() {

    }

    @Override
    public void register(String account, String password, String rePassword) {
        mView.showLoading();
//        RetrofitManager.create(WanAndroidApi.class).register(account,password,rePassword)
//                .compose(mView.bindToLife())
//                .compose(RxSchedulers.applySchedulers())
//                .subscribe(new Consumer<DataResponse>() {
//                    @Override
//                    public void accept(DataResponse dataResponse) throws Exception {
//                        if (dataResponse.getErrorCode()!=0){
//                            mView.showFaild(dataResponse.getErrorMsg().toString());
//                        }else {
//                            mView.showRegisterSuccess();
//                        }
//                        mView.hideLoading();
//                    }
//                }, this::loadError);
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        mView.hideLoading();
    }
}

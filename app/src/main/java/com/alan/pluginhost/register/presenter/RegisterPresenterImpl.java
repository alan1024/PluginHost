package com.alan.pluginhost.register.presenter;

import android.content.Context;

import com.alan.pluginhost.beans.UserBean;
import com.alan.pluginhost.register.model.RegisterModel;
import com.alan.pluginhost.register.model.RegisterModelImpl;
import com.alan.pluginhost.register.view.RegisterView;


public class RegisterPresenterImpl implements RegisterPresenter, RegisterModelImpl.OnRegisterListener {

    private RegisterView mView;
    private RegisterModel mModel;
    private Context mContext;

    public RegisterPresenterImpl(RegisterView view, Context context) {
        mView = view;
        mModel = new RegisterModelImpl();
        mContext = context;
    }

    @Override
    public void registerNewUser(UserBean user) {
        mView.showProgress();
        mModel.register(user, mContext, this);
    }

    @Override
    public void onSuccess() {
        mView.hideProgress();
        mView.showSuccessRegister();
    }

    @Override
    public void onFailure(int i, String s) {
        mView.hideProgress();
        mView.showFailureRegister(s);
    }
}

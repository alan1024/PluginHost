package com.alan.pluginhost.guide.presenter;

import android.content.Context;

import com.alan.pluginhost.beans.UserBean;
import com.alan.pluginhost.guide.model.GuideModel;
import com.alan.pluginhost.guide.model.GuideModelImpl;
import com.alan.pluginhost.guide.view.GuideView;

public class GuidePresenterImpl implements GuidePresenter, GuideModelImpl.OnCheckUserListener {
    private GuideView mView;
    private GuideModel mModel;
    private Context mContext;

    public GuidePresenterImpl(GuideView view, Context context) {
        this.mView = view;
        mContext = context;
        mModel = new GuideModelImpl(mContext);
    }

    @Override
    public void loadUserIfExist(UserBean user) {
        mView.showProgressbar();
        mModel.getUserFromCloud(user, this);
    }

    @Override
    public void onSuccess() {
        mView.hideProgressbar();
        mView.onSuccessFound();
    }

    @Override
    public void onFailure(String message) {
        mView.hideProgressbar();
        mView.onFailureFound(message);
    }
}

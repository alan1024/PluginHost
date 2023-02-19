package com.alan.pluginhost.guide.model;

import android.content.Context;

import com.alan.pluginhost.beans.UserBean;


public class GuideModelImpl implements GuideModel {

    private Context mContext;

    public GuideModelImpl(Context context) {
        mContext = context;
    }

    @Override
    public void getUserFromCloud(UserBean user, final OnCheckUserListener listener) {

    }

    public interface OnCheckUserListener {
        void onSuccess();

        void onFailure(String message);
    }
}

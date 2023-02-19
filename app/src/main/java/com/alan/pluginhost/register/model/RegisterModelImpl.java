package com.alan.pluginhost.register.model;

import android.content.Context;

import com.alan.pluginhost.beans.UserBean;


public class RegisterModelImpl implements RegisterModel {

    @Override
    public void register(UserBean user, Context context, final OnRegisterListener listener) {

    }

    public interface OnRegisterListener {
        void onSuccess();

        void onFailure(int i, String s);
    }
}

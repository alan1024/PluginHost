package com.alan.pluginhost.register.model;

import android.content.Context;

import com.alan.pluginhost.beans.UserBean;

public interface RegisterModel {
    void register(UserBean user, Context context, RegisterModelImpl.OnRegisterListener listener);
}

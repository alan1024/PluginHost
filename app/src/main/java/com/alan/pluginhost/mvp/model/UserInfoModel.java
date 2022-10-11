package com.alan.pluginhost.mvp.model;

import com.alan.pluginhost.model.bean.remote.MyUser;

public interface UserInfoModel {

    void update(MyUser user);

    void onUnsubscribe();
}

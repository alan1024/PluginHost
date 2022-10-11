package com.alan.pluginhost.mvp.presenter;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.model.bean.remote.MyUser;

public abstract  class UserInfoPresenter extends BasePresenter {

    public abstract void update(MyUser user);
}

package com.alan.pluginhost.guide.presenter;

import com.alan.pluginhost.beans.UserBean;

public interface GuidePresenter {
    void loadUserIfExist(UserBean user);
}

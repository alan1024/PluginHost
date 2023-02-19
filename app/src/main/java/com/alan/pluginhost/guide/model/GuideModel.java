package com.alan.pluginhost.guide.model;

import com.alan.pluginhost.beans.UserBean;


public interface GuideModel {
    void getUserFromCloud(UserBean user, GuideModelImpl.OnCheckUserListener listener);
}

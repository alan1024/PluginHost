package com.alan.pluginhost.bean;

import java.util.ArrayList;

public class OneNewsList {
    String newsType;
    OneNewsItemBean switchBannerBean;
    ArrayList<OneNewsItemBean> newsList;

    public ArrayList<OneNewsItemBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<OneNewsItemBean> newsList) {
        this.newsList = newsList;
    }

    public OneNewsItemBean getSwitchBannerBean() {
        return switchBannerBean;
    }

    public void setSwitchBannerBean(OneNewsItemBean switchBannerBean) {
        this.switchBannerBean = switchBannerBean;
    }
}

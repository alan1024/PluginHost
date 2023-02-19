package com.alan.pluginhost.images.view;

import com.alan.pluginhost.beans.ImageBean;

import java.util.List;

public interface ImageView {
    void addImages(List<ImageBean> images);

    void showProgress();

    void hideProgress();

    void showLoadFailMsg();
}

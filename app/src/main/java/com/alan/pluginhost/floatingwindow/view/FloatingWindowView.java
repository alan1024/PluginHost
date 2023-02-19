package com.alan.pluginhost.floatingwindow.view;

import com.alan.pluginhost.beans.NewsBean;

import java.util.List;


public interface FloatingWindowView {
    void getNews(List<NewsBean> newsList);

    void showErrorMessage(String message);

    void showProgressbar();

    void hideProgressbar();

    void showContentInView(String content);
}

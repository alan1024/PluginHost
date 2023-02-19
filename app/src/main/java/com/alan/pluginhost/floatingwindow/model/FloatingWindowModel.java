package com.alan.pluginhost.floatingwindow.model;


public interface FloatingWindowModel {
    void loadNews(int type, int page, FloatingWindowModelImpl.OnLoadNewsListListener listener);

    void loadNews(String url, int type, FloatingWindowModelImpl.OnLoadNewsListListener listener);

    void loadNewsDetail(String docid, FloatingWindowModelImpl.OnLoadNewsDetailListener listener);
}

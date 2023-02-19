package com.alan.pluginhost.news.model;

import com.alan.pluginhost.beans.UserBean;

public interface NewsModel {

    void loadNews(String url, int type, NewsModelImpl.OnLoadNewsListListener listener);

    void loadNewsDetail(String docid, NewsModelImpl.OnLoadNewsDetailListener listener);

    void sendCommentInDetailNews(UserBean user, String comment, NewsModelImpl.OnCommentDetailNewsListener listener);
}

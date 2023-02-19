package com.alan.pluginhost.news.presenter;

import com.alan.pluginhost.beans.UserBean;

/**
 * Created by SomeOneInTheWorld on 2016/5/28.
 */
public interface NewsDetailPresenter {

    void loadNewsDetail(String docId);

    void sendCommentToNews(UserBean user, String comment);
}

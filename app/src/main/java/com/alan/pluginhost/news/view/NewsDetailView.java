package com.alan.pluginhost.news.view;

import com.alan.pluginhost.beans.CommentBean;

import java.util.List;

/**
 * Created by SomeOneInTheWorld on 2016/5/25.
 */
public interface NewsDetailView {
    void showNewsDetailContent(String newsDetailContent, List<CommentBean> commentBeanList);

    void showProgress();

    void hideProgress();

    void successComment(String comment);

    void failureComment();
}

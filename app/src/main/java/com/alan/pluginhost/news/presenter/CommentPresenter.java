package com.alan.pluginhost.news.presenter;

import com.alan.pluginhost.beans.NewsBean;
import com.alan.pluginhost.beans.QuestionTable;
import com.alan.pluginhost.beans.ReplyTable;

/**
 * Created by SomeOneInTheWorld on 2016/8/24.
 */
public interface CommentPresenter {
    void saveQuestionByPresenter(QuestionTable table);

    void showQuestionsByPresenter(NewsBean newsBean);

    void saveQuestionAnswersByPresenter(ReplyTable table);

    void showQuestionAnswersByPresenter(QuestionTable table);

    void showQuestionReplyToAnswerByPresenter(ReplyTable replyTable);

    void queryNewsBeanByPresenter(String docid, NewsBean bean);
}

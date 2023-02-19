package com.alan.pluginhost.news.view;

import com.alan.pluginhost.beans.NewsBean;
import com.alan.pluginhost.beans.QuestionTable;
import com.alan.pluginhost.beans.ReplyTable;
import com.alan.pluginhost.beans.ReplyToReplyerTable;

import java.util.List;

/**
 * Created by SomeOneInTheWorld on 2016/8/24.
 */
public interface CommentView {
    void showProgress();

    void hideProgress();

    void saveQuestionSuccess();

    void saveQuestionFailure(int errorCode, String message);

    void queryQuestionSuccess(List<QuestionTable> list);

    void queryQuestionFailure(int errorCode, String message);

    void queryAnswersSuccess(List<ReplyTable> list);

    void queryAnswersFailure(int errorCode, String message);

    void queryReply2ReplyerSuccess(List<ReplyToReplyerTable> list);

    void queryReply2ReplyerFailure(int errorCode, String message);

    void queryNewsBeanSuccess(NewsBean bean);

    void saveNewsBeanSuccess(NewsBean bean);

    void saveNewsBeanFailure(int errorCode, String message);

    void saveQuestionAnswerSuccess();

    void saveQuestionAnswerFailure(int errorCode, String message);
}

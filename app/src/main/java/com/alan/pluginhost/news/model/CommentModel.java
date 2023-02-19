package com.alan.pluginhost.news.model;

import com.alan.pluginhost.beans.NewsBean;
import com.alan.pluginhost.beans.QuestionTable;
import com.alan.pluginhost.beans.ReplyTable;
import com.alan.pluginhost.beans.ReplyToReplyerTable;

import java.util.List;

public interface CommentModel {
    interface OnQueryCallback {
        void onQuestionSaveSuccess();

        void onQuestionSaveFailure(int errorCode, String message);

        void onQuestionQuerySuccess(List<QuestionTable> list);

        void onQuestionQueryFailure(int errorCode, String message);

        void onReplyQuerySuccess(List<ReplyTable> list);

        void onReplyQueryFailure(int errorCode, String message);

        void onReply2ReplyerQuerySuccess(List<ReplyToReplyerTable> list);

        void onReply2ReplyerQueryFailure(int errorCode, String message);

        void onQueryNewsBeanSuccess(NewsBean bean);

        void onQueryNewsBeanFailure(String message);

        void onSaveNewsBeanSuccess(NewsBean bean);

        void onSaveNewsBeanFailure(int errorCode, String message);

        void onSaveQuestionAnswerSuccess();

        void onSaveQuestionAnswerFailure(int errorCode, String message);
    }

    void saveQuestion(QuestionTable questionTable);

    void saveQuestionAnswers(ReplyTable table);

    void queryQuestionsForCommentArea(NewsBean bean);

    void queryQuestionAnswers(QuestionTable questionTable);

    void questionReplyToAnswers(ReplyTable replyTable);

    void queryNewsBean(String docid);

    void saveNewsBean(NewsBean bean);
}

package com.alan.pluginhost.news.presenter;

import android.content.Context;

import com.alan.pluginhost.beans.NewsBean;
import com.alan.pluginhost.beans.QuestionTable;
import com.alan.pluginhost.beans.ReplyTable;
import com.alan.pluginhost.beans.ReplyToReplyerTable;
import com.alan.pluginhost.news.model.CommentModel;
import com.alan.pluginhost.news.model.CommentModelImpl;
import com.alan.pluginhost.news.view.CommentView;
import com.alan.pluginhost.utils.LogUtils;

import java.util.List;

public class CommentPresenterImpl implements CommentPresenter, CommentModelImpl.OnQueryCallback {
    private CommentView mView;
    private CommentModel mModel;
    private String TAG = "COMMENTPRESENTERTT";

    private Context mContext;
    private NewsBean mNewsBean;

    public CommentPresenterImpl(Context context, CommentView view) {
        mContext = context;
        mView = view;
        mModel = new CommentModelImpl(context, this);
    }

    /**
     * 保存提问
     *
     * @param questionTable
     */
    @Override
    public void saveQuestionByPresenter(QuestionTable questionTable) {
        mView.showProgress();
        mModel.saveQuestion(questionTable);
    }

    /**
     * 展示问题
     *
     * @param bean
     */
    @Override
    public void showQuestionsByPresenter(NewsBean bean) {
        mView.showProgress();
        mModel.queryQuestionsForCommentArea(bean);
    }


    /**
     * 对于特定问题的特定回答，显示这个回答下的评论
     *
     * @param replyTable
     */
    @Override
    public void showQuestionReplyToAnswerByPresenter(ReplyTable replyTable) {
        mView.showProgress();
        mModel.questionReplyToAnswers(replyTable);
    }

    /**
     * 展示问题下的所有答案
     *
     * @param table
     */
    @Override
    public void showQuestionAnswersByPresenter(QuestionTable table) {
        mView.showProgress();
        mModel.queryQuestionAnswers(table);
    }

    @Override
    public void onQuestionSaveSuccess() {
        mView.hideProgress();
        mView.saveQuestionSuccess();
    }

    @Override
    public void onQuestionSaveFailure(int errorCode, String message) {
        mView.hideProgress();
        mView.saveQuestionFailure(errorCode, message);
    }

    @Override
    public void onQuestionQuerySuccess(List<QuestionTable> list) {
        mView.hideProgress();
        mView.queryQuestionSuccess(list);
    }

    @Override
    public void onQuestionQueryFailure(int errorCode, String message) {
        mView.hideProgress();
        mView.queryQuestionFailure(errorCode, message);
    }

    @Override
    public void onReplyQuerySuccess(List<ReplyTable> list) {
        mView.hideProgress();
        mView.queryAnswersSuccess(list);
    }

    @Override
    public void onReplyQueryFailure(int errorCode, String message) {
        mView.hideProgress();
        mView.queryAnswersFailure(errorCode, message);
    }

    @Override
    public void onReply2ReplyerQuerySuccess(List<ReplyToReplyerTable> list) {
        mView.hideProgress();
        mView.queryReply2ReplyerSuccess(list);
    }

    @Override
    public void onReply2ReplyerQueryFailure(int errorCode, String message) {
        mView.hideProgress();
        mView.queryReply2ReplyerFailure(errorCode, message);
    }

    @Override
    public void queryNewsBeanByPresenter(String docid, NewsBean bean) {
        LogUtils.d(TAG, "bean is " + bean);
        mNewsBean = bean;
        mView.showProgress();
        mModel.queryNewsBean(docid);
    }

    @Override
    public void onQueryNewsBeanSuccess(NewsBean bean) {
        LogUtils.d(TAG, "onqueryNewsBeanSuccess and bean is " + bean.getTitle());
        mView.queryNewsBeanSuccess(bean);
        mView.hideProgress();
    }

    @Override
    public void saveQuestionAnswersByPresenter(ReplyTable table) {
        mView.showProgress();
        mModel.saveQuestionAnswers(table);
    }

    @Override
    public void onQueryNewsBeanFailure(String message) {
        LogUtils.d(TAG, "queryFailure and message is " + message);
        mView.showProgress();
        mModel.saveNewsBean(mNewsBean);
    }

    @Override
    public void onSaveNewsBeanSuccess(NewsBean bean) {
        LogUtils.d(TAG, "save success and bean is " + bean);
        mView.saveNewsBeanSuccess(bean);
        mView.hideProgress();
    }

    @Override
    public void onSaveQuestionAnswerSuccess() {
        mView.hideProgress();
        mView.saveQuestionAnswerSuccess();
    }

    @Override
    public void onSaveQuestionAnswerFailure(int errorCode, String message) {
        mView.hideProgress();
        mView.saveQuestionAnswerFailure(errorCode, message);
    }

    @Override
    public void onSaveNewsBeanFailure(int errorCode, String message) {
        LogUtils.d(TAG, "save failue and error is " + errorCode);
        mView.saveNewsBeanFailure(errorCode, message);
        mView.hideProgress();
    }
}

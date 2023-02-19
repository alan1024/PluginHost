package com.alan.pluginhost.beans;

import java.io.Serializable;

public class ReplyTable implements Serializable {
    private QuestionTable questionId;
    private UserBean replyerId;
    private Integer replyId;
    private String reply_content;

    public void setQuestionId(QuestionTable questionId) {
        this.questionId = questionId;
    }

    public QuestionTable getQuestionId() {
        return questionId;
    }

    public void setReplyerId(UserBean replyerId) {
        this.replyerId = replyerId;
    }

    public UserBean getReplyerId() {
        return replyerId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public String getReply_content() {
        return reply_content;
    }
}

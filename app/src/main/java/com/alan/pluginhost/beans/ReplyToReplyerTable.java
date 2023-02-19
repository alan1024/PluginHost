package com.alan.pluginhost.beans;

public class ReplyToReplyerTable {
    private ReplyTable replyId;
    private UserBean replyToReplyerId;
    private Integer replyToReplyId;
    private QuestionTable questionTable;
    private String replyToReply_content;

    public void setReplyId(ReplyTable replyId) {
        this.replyId = replyId;
    }

    public ReplyTable getReplyId() {
        return replyId;
    }

    public void setReplyToReplyerId(UserBean replyToReplyerId) {
        this.replyToReplyerId = replyToReplyerId;
    }

    public UserBean getReplyToReplyerId() {
        return replyToReplyerId;
    }

    public void setReplyToReplyId(Integer replyToReplyId) {
        this.replyToReplyId = replyToReplyId;
    }

    public Integer getReplyToReplyId() {
        return replyToReplyId;
    }

    public void setQuestionTable(QuestionTable questionTable) {
        this.questionTable = questionTable;
    }

    public QuestionTable getQuestionTable() {
        return questionTable;
    }

    public void setReplyToReply_content(String replyToReply_content) {
        this.replyToReply_content = replyToReply_content;
    }

    public String getReplyToReply_content() {
        return replyToReply_content;
    }
}

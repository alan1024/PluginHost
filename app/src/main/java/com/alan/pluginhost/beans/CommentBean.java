package com.alan.pluginhost.beans;


public class CommentBean {
    private String Content;
    private UserBean comment_people;
    private String docid;

    public void setContent(String content) {
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getDocid() {
        return docid;
    }

    public void setComment_people(UserBean comment_people) {
        this.comment_people = comment_people;
    }

    public UserBean getComment_people() {
        return comment_people;
    }
}

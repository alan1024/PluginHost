package com.alan.pluginhost.other;

import com.alan.pluginhost.base.Comment;

public class CommentJo extends Comment {

    private Integer uid;
    private String nick;//昵称
    private String head;//头像

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}

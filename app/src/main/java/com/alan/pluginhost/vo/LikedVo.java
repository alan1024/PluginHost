package com.alan.pluginhost.vo;


import com.alan.pluginhost.base.Liked;

public class LikedVo extends Liked {

    private Integer uid;
    private String head;
    private String nick;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}

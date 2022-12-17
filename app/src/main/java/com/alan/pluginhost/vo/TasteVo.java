package com.alan.pluginhost.vo;

import com.alan.pluginhost.base.Taste;

public class TasteVo extends Taste {

    private Integer uid;
    private String nick;

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

    @Override
    public String toString() {
        return super.toString() + "TasteVo{" +
                "uid=" + uid +
                ", nick='" + nick + '\'' +
                '}';
    }
}

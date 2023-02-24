package com.alan.pluginhost.bean.newstext;


public class NewRoot {
    private NewsID newsID;

    public void setNewsID(NewsID newsID) {
        this.newsID = newsID;
    }

    public NewsID getNewsID() {
        return this.newsID;
    }

    @Override
    public String toString() {
        return "NewRoot{" +
                "newsID=" + newsID +
                '}';
    }
}
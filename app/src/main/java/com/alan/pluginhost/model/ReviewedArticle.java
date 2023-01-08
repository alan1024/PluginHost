package com.alan.pluginhost.model;


public class ReviewedArticle {
    public int type;

    public int aid;


    public String photoKey;

    public String title;

    //阅读时间
    public long clickTime;


    public ReviewedArticle() {
        super();
    }


    @Override
    public String toString() {
        return "ReviewedArticle{" + "type=" + type + ", aid=" + aid + ", photoKey='" + photoKey + '\'' + ", title='" + title + '\'' + ", clickTime=" + clickTime + '}';
    }
}

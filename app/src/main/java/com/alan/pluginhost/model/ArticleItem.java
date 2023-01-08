package com.alan.pluginhost.model;

import java.util.Arrays;

public class ArticleItem extends SimpleArticleItem {
    // 图片资源不是必须的
    private String source;
    private String body;

    public ArticleItem() {

    }

    public ArticleItem(int id, String[] imageUrls, String title, String publishDate, int readTimes, String source,
                       String body) {
        super(id, imageUrls, title, publishDate, readTimes);
        this.source = source;
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ArticleItem [aid=" + getId() + ",\n imageUrls=" + Arrays.toString(getImageUrls()) + ",\n title="
                + getTitle() + ",\n publishDate=" + getPublishDate() + ",\n source=" + source + ",\n readTimes="
                + getReadTimes() + ",\n body=" + body + "]";
    }

}
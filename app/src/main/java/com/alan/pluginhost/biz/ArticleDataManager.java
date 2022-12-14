package com.alan.pluginhost.biz;


import com.alan.pluginhost.entity.ArticleBean;

import org.w3c.dom.Document;

public class ArticleDataManager {
    private String articleId;

    public ArticleDataManager(String articleId) {
        this.articleId = articleId;
    }


    public ArticleBean getArticleBean(Document document) {
        ArticleBean articleBean = new ArticleBean();

        return articleBean;
    }

    /**
     * 进行抓取文章详情
     *
     * @param document
     * @return
     */
    public ArticleBean getArticleBean_CNK(Document document) {
        ArticleBean bean = new ArticleBean();

        return bean;
    }
}

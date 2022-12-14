package com.alan.pluginhost.biz;


import com.alan.pluginhost.entity.HomeNewsBean;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class HomeNewsDataManager {
    public HomeNewsDataManager() {
    }

    /**
     * 进行抓取首页信息数据
     *
     * @param document
     * @return
     */
    public List<HomeNewsBean> getHomeNewsBeans(Document document) {
        List<HomeNewsBean> homeNewsBeans = new ArrayList<HomeNewsBean>();

        return homeNewsBeans;
    }

    /**
     * 抓取文章类别数据 根据分类
     *
     * @param document
     * @return
     */
    public List<HomeNewsBean> getHomeNewsBeans_CNK(Document document) {
        List<HomeNewsBean> homeNewsBeans = new ArrayList<HomeNewsBean>();


        return homeNewsBeans;
    }
}

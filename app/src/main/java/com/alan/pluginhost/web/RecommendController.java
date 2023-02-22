package com.alan.pluginhost.web;

import com.alan.pluginhost.News;
import com.alan.pluginhost.NewsRepository;
import com.alan.pluginhost.hot.HotRecommenderService;
import com.alan.pluginhost.userCF.UserCFRecommenderService;

import java.util.List;

public class RecommendController {
    private UserCFRecommenderService userCFRecommenderService;
    private HotRecommenderService hotRecommenderService;
    private NewsRepository newsRepository;

    public String index() {
        return "Recommender for Todayim";
    }

    public List<News> getRecommendNews(long id) {
        return userCFRecommenderService.recommendNews(id);
    }
}

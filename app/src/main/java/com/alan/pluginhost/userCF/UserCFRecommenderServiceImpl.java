package com.alan.pluginhost.userCF;

import com.alan.pluginhost.News;
import com.alan.pluginhost.NewsRepository;
import com.alan.pluginhost.UserOperationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


public class UserCFRecommenderServiceImpl implements UserCFRecommenderService {

    private String tableName;

    private String userColumn;

    private String itemColumn;

    private String prefColumn;

    private int recommendNum;

    DataSource dataSource;

    NewsRepository newsRepository;

    UserOperationRepository userOperationRepository;


    public UserCFRecommenderServiceImpl() {

    }

    public void init() {

    }

    @Override
    public Map<String, Double> evaluate(int neighborhoodNum, String method) {

        return null;
    }

    /**
     * 向用户推荐新闻
     *
     * @param userId 用户id
     * @return 新闻id的list
     */
    @Override
    public List<Long> recommend(long userId) {
        List<Long> ret = new ArrayList<>();


        return ret;
    }

    @Override
    public List<News> recommendNews(long userId) {
        return null;
    }


}

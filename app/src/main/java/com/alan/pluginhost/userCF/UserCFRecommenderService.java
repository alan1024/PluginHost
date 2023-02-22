package com.alan.pluginhost.userCF;


import com.alan.pluginhost.News;

import java.util.List;
import java.util.Map;

public interface UserCFRecommenderService {

    List<Long> recommend(long userId);

    List<News> recommendNews(long userId);

    Map<String, Double> evaluate(int neighborhoodNum, String method);
}

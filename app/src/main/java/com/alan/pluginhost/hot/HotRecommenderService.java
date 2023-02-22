package com.alan.pluginhost.hot;


import com.alan.pluginhost.News;

import java.util.List;
import java.util.Map;

public interface HotRecommenderService {
    List<Long> recommend(long userId);

    List<News> recommendNews(long userId);

    Map<String, Double> evaluate();

}

package com.alan.pluginhost.contentBased;

import java.util.List;
import java.util.Map;

public interface ContentBasedRecommenderService {
    List<Long> recommend(long userId);

    Map<String, Double> evaluate();
}

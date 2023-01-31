package com.alan.pluginhost.model.news;

import com.alan.pluginhost.model.entity.ShowApiNews;
import com.alan.pluginhost.model.entity.ShowApiResponse;

import retrofit2.Call;

public interface NewsModel {
    /**
     * 加载新闻列表
     *
     * @param page        页数
     * @param channelId   频道id 来自api
     * @param channelName 频道名称
     */
    Call<ShowApiResponse<ShowApiNews>> netLoadNewsList(int page, String channelId, String channelName);
}

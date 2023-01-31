package com.alan.pluginhost.model.news;


import com.alan.pluginhost.model.entity.ShowApiNews;
import com.alan.pluginhost.model.entity.ShowApiResponse;

import retrofit2.Call;


public class NewsModelImpl implements NewsModel {
    public static final String CHANNEL_ID = "5572a109b3cdc86cf39001db";//频道id 来自api指定
    public static final String CHANNEL_NAME = "国内最新";//频道名称 来自api指定

    @Override
    public Call<ShowApiResponse<ShowApiNews>> netLoadNewsList(int page, String channelId, String channelName) {

        return null;

        /*call.enqueue(new Callback<ShowApiResponse<ShowApiNews>>() {
            @Override
            public void onResponse(Call<ShowApiResponse<ShowApiNews>> call, Response<ShowApiResponse<ShowApiNews>> response) {
                Logger.d(response.message() + response.code() + response.body().showapi_res_code
                        + response.body().showapi_res_error);
                if (response.body() != null && TextUtils.equals("0", response.body().showapi_res_code)) {
                    listListener.onSuccess(response.body().showapi_res_body.pagebean.contentlist);
                } else {
                    listListener.onFailure(new Exception());
                }
            }

            @Override
            public void onFailure(Call<ShowApiResponse<ShowApiNews>> call, Throwable t) {
                listListener.onFailure(t);
            }
        });*/
    }
}

package com.alan.pluginhost.api;


public class ApiManager {

    private DouBanApi mDouBanApi;
    private ZhihuDailyApi mDailyApi;
    private NetEasyNewsApi mNewsApi;
    private MovieApi mMovieApi;
    private GithubApi mGithubApi;
    private static ApiManager sApiManager;


    private ApiManager() {

    }

    public static ApiManager getInstence() {
        if (sApiManager == null) {
            synchronized (ApiManager.class) {
                if (sApiManager == null) {
                    sApiManager = new ApiManager();
                }
            }
        }
        return sApiManager;
    }

    /**
     * 封装配置豆瓣API
     */
    public DouBanApi getDoubanService() {
        if (mDouBanApi == null) {

        }
        return mDouBanApi;
    }

    /**
     * 封装配置知乎API
     */
    public ZhihuDailyApi getZhihuService() {
        if (mDailyApi == null) {

        }
        return mDailyApi;
    }

    /**
     * 封装网易新闻API
     */
    public NetEasyNewsApi getTopNewsServie() {
        if (mNewsApi == null) {

        }
        return mNewsApi;
    }

    /**
     * 封装视频 API
     */
    public MovieApi getMovieService() {
        if (mMovieApi == null) {

        }
        return mMovieApi;
    }

    /**
     * 封装 gayhub API
     */
    public GithubApi getGithubService() {
        if (mGithubApi == null) {

        }
        return mGithubApi;
    }

}

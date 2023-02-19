package com.alan.pluginhost.news.presenter;

import com.alan.pluginhost.beans.NewsBean;
import com.alan.pluginhost.common.Urls;
import com.alan.pluginhost.news.model.NewsModel;
import com.alan.pluginhost.news.model.NewsModelImpl;
import com.alan.pluginhost.news.view.NewsView;
import com.alan.pluginhost.utils.LogUtils;

import java.util.List;

public class NewsPresenterImpl implements NewsPresenter, NewsModelImpl.OnLoadNewsListListener {

    private static final String TAG = "NewsPresenterImpl";

    private NewsView mNewsView;
    private NewsModel mNewsModel;

    private int mType;

    public NewsPresenterImpl(NewsView newsView) {
        mNewsView = newsView;
        mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNews(int type, int page) {
        String url = getUrl(type, page);
        LogUtils.d(TAG, url);
        mType = type;

        if (page == 0) {
            mNewsView.showProgress();
        }

        mNewsModel.loadNews(url, type, this);
    }

    private String getUrl(int type, int page) {
        StringBuffer sb = new StringBuffer();
        switch (type) {
//            case NewsFragment.NEWS_TYPE_TOP:
//                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
//                break;
//            case NewsFragment.NEWS_TYPE_NBA:
//                sb.append(Urls.COMMON_URL).append(Urls.NBA_ID);
//                break;
//            case NewsFragment.NEWS_TYPE_JOKES:
//                sb.append(Urls.COMMON_URL).append(Urls.JOKE_ID);
//                break;
//            case NewsFragment.NEWS_TYPE_CARS:
//                sb.append(Urls.COMMON_URL).append(Urls.CAR_ID);
//                break;
            default:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
        }
        sb.append('/').append(page).append(Urls.END_URL);
        return sb.toString();
    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        LogUtils.d("TAGGGGGGGGG", "onSuccess in presenterImpl");
        mNewsView.hideProgress();
        for (NewsBean bean : list) {
            bean.setTag(getTagByType(mType));
        }
        mNewsView.addNews(list);
    }

    public static String getTagByType(int type) {
        switch (type) {
//            case NewsFragment.NEWS_TYPE_CARS:
//                return "cars";
//            case NewsFragment.NEWS_TYPE_JOKES:
//                return "jokes";
//            case NewsFragment.NEWS_TYPE_NBA:
//                return "nba";
//            case NewsFragment.NEWS_TYPE_TOP:
//                return "top";
            default:
                return "top";
        }
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsView.hideProgress();
        mNewsView.showLoadFailMsg();
    }
}

package com.alan.pluginhost.modules.news.newsdetail;

import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

class NewsDetailPresenter extends BasePresenter implements NewsDetailContract.Presenter {
    private NewsDetailContract.View mActivity;

    /**
     * 加载新闻详情
     */
    @Override
    public void loadNewsContent(final String id) {
        mActivity.showProgressBar();
//        ApiManager.getInstence()
//                .getTopNewsServie()
//                .getNewsContent(id)
//                .map(new Function<ResponseBody, NewsContent>() {
//                    @Override
//                    public NewsContent apply(ResponseBody responseBody) {
//                        NewsContent topNews = null;
//                        try {
//                            topNews = JsonUtils.readJsonNewsContent(responseBody.string(), id);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        return topNews;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<NewsContent>() {
//                    @Override
//                    public void onComplete() {
//                        mActivity.hideProgressBar();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mActivity.hideProgressBar();
//                        mActivity.loadFail(e.getMessage());
//                    }
//
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(NewsContent response) {
//                        mActivity.hideProgressBar();
//                        mActivity.loadSuccess(response);
//                    }
//                });

    }

    @Override
    public void bindView(ImpBaseView view) {
        mActivity = (NewsDetailContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mActivity = null;
    }
}

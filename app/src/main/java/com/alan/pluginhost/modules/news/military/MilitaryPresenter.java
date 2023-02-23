package com.alan.pluginhost.modules.news.military;

import com.alan.pluginhost.HostApp;
import com.alan.pluginhost.config.Constants;
import com.alan.pluginhost.disklrucache.DiskCacheManager;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;
import com.alan.pluginhost.modules.news.NewsContract;

import java.util.ArrayList;


class MilitaryPresenter extends BasePresenter implements NewsContract.Presenter {

    private NewsContract.View mNewsListFrag;
    private int currentIndex;

    @Override
    public void refreshNews() {
        mNewsListFrag.showRefreshBar();
        currentIndex = 0;
//        ApiManager.getInstence().getTopNewsServie()
//                .getMilitaryNews(currentIndex + "")
//                .map(new Function<MilitaryNewsList, ArrayList<NewsBean>>() {
//                    @Override
//                    public ArrayList<NewsBean> apply(MilitaryNewsList militaryNewsList) {
//                        return militaryNewsList.getMilitaryNewsArrayList();
//                    }
//                })
//                .flatMap(new Function<ArrayList<NewsBean>, Observable<NewsBean>>() {
//                    @Override
//                    public Observable<NewsBean> apply(ArrayList<NewsBean> topNewses) throws Exception {
//                        return Observable.fromIterable(topNewses);
//                    }
//                })
//                .filter(new Predicate<NewsBean>() {
//                    @Override
//                    public boolean test(NewsBean topNews) throws Exception {
//                        return topNews.getUrl() != null;
//                    }
//                })
//                .map(new Function<NewsBean, BaseItem>() {
//                    @Override
//                    public BaseItem apply(NewsBean topNews) {
//                        BaseItem<NewsBean> baseItem = new BaseItem<>();
//                        baseItem.setData(topNews);
//                        return baseItem;
//                    }
//                })
//                .toList()
//                //将 List 转为ArrayList 缓存存储 ArrayList Serializable对象
//                .map(new Function<List<BaseItem>, ArrayList<BaseItem>>() {
//                    @Override
//                    public ArrayList<BaseItem> apply(List<BaseItem> baseItems) {
//                        ArrayList<BaseItem> items = new ArrayList<>();
//                        items.addAll(baseItems);
//                        return items;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<ArrayList<BaseItem>>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(ArrayList<BaseItem> value) {
//                        DiskCacheManager manager = new DiskCacheManager(HostApp.getInstance(), Constants.CACHE_NEWS_FILE);
//                        manager.put(Constants.CACHE_MILITARY_NEWS, value);
//                        currentIndex += 20;
//                        mNewsListFrag.hideRefreshBar();
//                        mNewsListFrag.refreshNewsSuccessed(value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mNewsListFrag.hideRefreshBar();
//                        mNewsListFrag.refreshNewsFail(e.getMessage());
//                    }
//
//                });
    }

    //两个方法没区别,只是刷新会重新赋值
    @Override
    public void loadMore() {
//        ApiManager.getInstence().getTopNewsServie()
//                .getMilitaryNews(currentIndex + "")
//                .map(new Function<MilitaryNewsList, ArrayList<NewsBean>>() {
//                    @Override
//                    public ArrayList<NewsBean> apply(MilitaryNewsList militaryNewsList) {
//                        return militaryNewsList.getMilitaryNewsArrayList();
//                    }
//                })
//                .flatMap(new Function<ArrayList<NewsBean>, Observable<NewsBean>>() {
//                    @Override
//                    public Observable<NewsBean> apply(ArrayList<NewsBean> topNewses) {
//                        return Observable.fromIterable(topNewses);
//                    }
//                })
//                .filter(new Predicate<NewsBean>() {
//                    @Override
//                    public boolean test(NewsBean topNews) {
//                        return topNews.getUrl() != null;
//                    }
//                })
//                .map(new Function<NewsBean, BaseItem>() {
//                    @Override
//                    public BaseItem apply(NewsBean topNews) {
//                        BaseItem<NewsBean> baseItem = new BaseItem<>();
//                        baseItem.setData(topNews);
//                        return baseItem;
//                    }
//                })
//                .toList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<BaseItem>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(List<BaseItem> value) {
//                        if (value != null && value.size() > 0) {
//                            //每刷新成功一次多加载20条
//                            currentIndex += 20;
//                            mNewsListFrag.loadMoreSuccessed((ArrayList<BaseItem>) value);
//                        } else {
//                            mNewsListFrag.loadAll();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mNewsListFrag.loadMoreFail(e.getMessage());
//                    }
//
//                });

    }

    /**
     * 读取缓存
     */
    @Override
    public void loadCache() {
        DiskCacheManager manager = new DiskCacheManager(HostApp.getInstance(), Constants.CACHE_NEWS_FILE);
        ArrayList<BaseItem> topNews = manager.getSerializable(Constants.CACHE_MILITARY_NEWS);
        if (topNews != null) {
            mNewsListFrag.refreshNewsSuccessed(topNews);
        }
    }

    @Override
    public void bindView(ImpBaseView view) {
        mNewsListFrag = (NewsContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mNewsListFrag = null;
    }
}

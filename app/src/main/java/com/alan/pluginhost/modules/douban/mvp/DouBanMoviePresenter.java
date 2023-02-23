package com.alan.pluginhost.modules.douban.mvp;

import com.alan.pluginhost.HostApp;
import com.alan.pluginhost.config.Constants;
import com.alan.pluginhost.disklrucache.DiskCacheManager;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;


class DouBanMoviePresenter extends BasePresenter implements DoubanContract.Presenter {

    private DoubanContract.View mMovieListFrag;
    private int start;
    private boolean loadAllCompleted = false;

    /**
     * 刷新操作
     */
    public void refreshData() {
        mMovieListFrag.showProgressBar();
//        ApiManager.getInstence().getDoubanService()
//                .getTop250(0, 20)
//                .flatMap(new Function<MovieTop250, ObservableSource<MovieSubject>>() {
//                    @Override
//                    public Observable<MovieSubject> apply(MovieTop250 movieTop250) throws Exception {
//                        //刷新后下一次加载的起点为
//                        start = movieTop250.getCount();
//                        return Observable.fromIterable(movieTop250.getMovieSubjects());
//                    }
//                })
//                .map(new Function<MovieSubject, BaseItem>() {
//                    @Override
//                    public BaseItem apply(MovieSubject movieSubject) {
//                        BaseItem<MovieSubject> baseItem = new BaseItem<>();
//                        baseItem.setData(movieSubject);
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
//                        DiskCacheManager manager = new DiskCacheManager(HostApp.getInstance(), Constants.CACHE_DOUBAN_FILE);
//                        manager.put(Constants.CACHE_DOUBAN_MOVIE, items);
//                        return items;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<ArrayList<BaseItem>>() {
//                    @Override
//                    public void onError(Throwable e) {
//                        mMovieListFrag.hideProgressBar();
//                        mMovieListFrag.refreshFail(e.getMessage());
//                    }
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(ArrayList<BaseItem> value) {
//                        mMovieListFrag.hideProgressBar();
//                        mMovieListFrag.refreshSucceed(value);
//                    }
//
//                });
    }

    /**
     * 对外提供的加载更多方法，当还未全部加载完的时候回去加载更多
     */
    public void loadMoreData() {
        if (!loadAllCompleted) {
            loadMore();
        }
    }

    /**
     * 加载更多
     */
    private void loadMore() {
//        ApiManager.getInstence().getDoubanService()
//                .getTop250(start, 20)
//                .flatMap(new Function<MovieTop250, ObservableSource<MovieSubject>>() {
//                    @Override
//                    public ObservableSource<MovieSubject> apply(MovieTop250 movieTop250) {
//                        //刷新后下一次加载的起点为
//                        start += movieTop250.getCount();
//                        if (start == movieTop250.getTotal()) {
//                            loadAllCompleted = true;
//                        }
//                        return Observable.fromIterable(movieTop250.getMovieSubjects());
//                    }
//                })
//                .map(new Function<MovieSubject, BaseItem>() {
//                    @Override
//                    public BaseItem apply(MovieSubject movieSubject) {
//                        BaseItem<MovieSubject> baseItem = new BaseItem<>();
//                        baseItem.setData(movieSubject);
//                        return baseItem;
//                    }
//                })
//                .toList()
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
//                    @Override
//                    public void onError(Throwable e) {
//                        mMovieListFrag.hideProgressBar();
//                        mMovieListFrag.loadFail(e.getMessage());
//                    }
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(ArrayList<BaseItem> value) {
//                        mMovieListFrag.hideProgressBar();
//                        if (value != null) {
//                            mMovieListFrag.loadSuccessed(value);
//                        } else {
//                            mMovieListFrag.loadFail("null value");
//                        }
//                    }
//
//                });
    }

    /**
     * 加载缓存
     */
    public void loadCache() {
        DiskCacheManager manager = new DiskCacheManager(HostApp.getInstance(), Constants.CACHE_DOUBAN_FILE);
        ArrayList<BaseItem> movieSubjects = manager.getSerializable(Constants.CACHE_DOUBAN_MOVIE);
        if (movieSubjects != null) {
            mMovieListFrag.refreshSucceed(movieSubjects);
        }
    }

    @Override
    public void bindView(ImpBaseView view) {
        mMovieListFrag = (DoubanContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mMovieListFrag = null;
    }
}

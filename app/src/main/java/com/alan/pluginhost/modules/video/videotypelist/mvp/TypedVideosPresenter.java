package com.alan.pluginhost.modules.video.videotypelist.mvp;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.config.Constants;
import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


class TypedVideosPresenter extends BasePresenter implements VideoTypedContract.Presenter {
    private VideoTypedContract.View mActivity;
    private int currentPage = 0;

    @Override
    public void loadVideos(String catalogId) {
//        ApiManager
//                .getInstence()
//                .getMovieService()
//                .getTypedVideos(catalogId, String.valueOf(currentPage + 1))
//                .map(new Function<MovieResponse<TypedVideos>, List<TypedVideos.ListBean>>() {
//                    @Override
//                    public List<TypedVideos.ListBean> apply(MovieResponse<TypedVideos> response) {
//                        currentPage = response.getData().getPnum();
//                        int totalPum = response.getData().getTotalPnum();
//                        if (currentPage == totalPum) { //加载完所有的视频后
//                            mActivity.noMoreVideo();
//                        }
//                        return response.getData().getList();
//                    }
//                })
//                .flatMap(new Function<List<TypedVideos.ListBean>, Observable<TypedVideos.ListBean>>() {
//                    @Override
//                    public Observable<TypedVideos.ListBean> apply(List<TypedVideos.ListBean> listBeen) {
//                        return Observable.fromIterable(listBeen);
//                    }
//                })
//                .map(new Function<TypedVideos.ListBean, BaseItem>() {
//                    @Override
//                    public BaseItem apply(TypedVideos.ListBean listBean) {
//                        BaseItem<TypedVideos.ListBean> base = new BaseItem<>();
//                        base.setData(listBean);
//                        return base;
//                    }
//                })
//                .toList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<BaseItem>>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(List<BaseItem> value) {
//                        mActivity.loadMoreSuccess((ArrayList<BaseItem>) value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mActivity.loadFail(Constants.ERRO, e.getMessage());
//                    }
//
//                });
    }

    @Override
    public void loadLives(String catalogId) {
//        ApiManager
//                .getInstence()
//                .getMovieService()
//                .getLiveVideo(catalogId, String.valueOf(currentPage + 1))
//                .map(new Function<MovieResponse<TypedVideos>, List<TypedVideos.ListBean>>() {
//                    @Override
//                    public List<TypedVideos.ListBean> apply(MovieResponse<TypedVideos> response) {
//                        currentPage = response.getData().getPnum();
//                        int totalPum = response.getData().getTotalPnum();
//                        if (currentPage == totalPum) { //加载完所有的视频后
//                            mActivity.noMoreVideo();
//                        }
//                        return response.getData().getList();
//                    }
//                })
//                .flatMap(new Function<List<TypedVideos.ListBean>, Observable<TypedVideos.ListBean>>() {
//                    @Override
//                    public Observable<TypedVideos.ListBean> apply(List<TypedVideos.ListBean> listBeen) {
//                        return Observable.fromIterable(listBeen);
//                    }
//                })
//                .map(new Function<TypedVideos.ListBean, BaseItem>() {
//                    @Override
//                    public BaseItem apply(TypedVideos.ListBean listBean) {
//                        BaseItem<TypedVideos.ListBean> base = new BaseItem<>();
//                        base.setData(listBean);
//                        return base;
//                    }
//                })
//                .toList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<BaseItem>>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(List<BaseItem> value) {
//                        mActivity.loadMoreSuccess((ArrayList<BaseItem>) value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mActivity.loadFail(Constants.ERRO, e.getMessage());
//                    }
//
//                });

    }

    @Override
    public void loadData(String title) {
        switch (title) {
            case Constants.MOVIE_TYPE_BIGBRO:
                loadVideos(Config.MOVIE_TYPE_BIGBRO);
                break;
            case Constants.MOVIE_TYPE_HOLLYWOOD:
                loadVideos(Config.MOVIE_TYPE_HOLLYWOOD);
                break;
            case Constants.MOVIE_TYPE_HOT:
                loadVideos(Config.MOVIE_TYPE_HOT);
                break;
            case Constants.MOVIE_TYPE_JSKS:
                loadVideos(Config.MOVIE_TYPE_JSKS);
                break;
            case Constants.MOVIE_TYPE_LITTLEMOVIE:
                loadVideos(Config.MOVIE_TYPE_LITTLEMOVIE);
                break;
            case Constants.MOVIE_TYPE_LIVE:
                loadLives(Config.MOVIE_TYPE_LIVE);
                break;
            case Constants.MOVIE_TYPE_MIDNIGHT:
                loadVideos(Config.MOVIE_TYPE_MIDNIGHT);
                break;
            case Constants.MOVIE_TYPE_RECOMMEND:
                loadVideos(Config.MOVIE_TYPE_RECOMMEND);
                break;
            case Constants.MOVIE_TYPE_TOPIC:
//                loadVideos(Config.MOVIE_TYPE_TOPIC);
                break;
            case Constants.MOVIE_TYPE_BIG:
                loadVideos(Config.MOVIE_TYPE_BIG);
                break;
            case Constants.MOVIE_TYPE_HONGKONG:
                loadVideos(Config.MOVIE_TYPE_HONGKONG);
                break;
        }
    }

    @Override
    public void bindView(ImpBaseView view) {
        mActivity = (VideoTypedContract.View) view;
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

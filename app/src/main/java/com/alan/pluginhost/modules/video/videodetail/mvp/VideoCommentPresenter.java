package com.alan.pluginhost.modules.video.videodetail.mvp;

import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


class VideoCommentPresenter extends BasePresenter implements VideoCommentContract.Presenter {
    private int currentPage = 0;

    private VideoCommentContract.View mCommentFrag;

    /**
     * 获取视频评论
     */
    private void loadVideoComment() {
//        ApiManager.getInstence()
//                .getMovieService()
//                .getCommentList(mCommentFrag.getDataId(), String.valueOf(currentPage + 1))
//                .map(new Function<MovieResponse<CommentBean>, CommentBean>() {
//                    @Override
//                    public CommentBean apply(MovieResponse<CommentBean> response) {
//                        currentPage = response.getData().getPnum();
//                        int totalPum = response.getData().getTotalPnum();
//                        if (currentPage == totalPum) { //加载完所有的评论后
//                            mCommentFrag.noMore();
//                        }
//                        return response.getData();
//                    }
//                })
//                .flatMap(new Function<CommentBean, Observable<CommentBean.ListBean>>() {
//                    @Override
//                    public Observable<CommentBean.ListBean> apply(CommentBean commentBean) throws Exception {
//                        return Observable.fromIterable(commentBean.getList());
//                    }
//                })
//                .map(new Function<CommentBean.ListBean, BaseItem>() {
//                    @Override
//                    public BaseItem<CommentBean.ListBean> apply(CommentBean.ListBean listBean) throws Exception {
//                        BaseItem<CommentBean.ListBean> base = new BaseItem<>();
//                        base.setData(listBean);
//                        return base;
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
//                        mCommentFrag.showComment((ArrayList<BaseItem>) value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mCommentFrag.loadFail();
//                    }
//                });

    }

    /**
     * 刷新评论
     */
    @Override
    public void refreshComment() {
        currentPage = 0;
        loadVideoComment();
    }

    /**
     * 加载更多评论
     */
    @Override
    public void loadMoreComment() {
        loadVideoComment();
    }

    @Override
    public void bindView(ImpBaseView view) {
        mCommentFrag = (VideoCommentContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mCommentFrag = null;
    }
}

package com.alan.pluginhost.modules.douban.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alan.pluginhost.BaseFragment;
import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;
import com.alan.pluginhost.magicrecyclerView.MagicRecyclerView;
import com.alan.pluginhost.modules.douban.MovieListAdapter;

import java.util.ArrayList;


public class MovieListFragment extends BaseFragment implements DoubanContract.View, SwipeRefreshLayout.OnRefreshListener {
    MagicRecyclerView mMovieList;
    SwipeRefreshLayout mSrlRefresh;
    private MovieListAdapter mMovieListAdapter;
    private DoubanContract.Presenter mPresenter;
    private boolean loading = false;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        bindPresenter();
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        onHiddenChanged(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSrlRefresh.setRefreshing(false);
        unbindPresenter();
        onHiddenChanged(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destoryPresenter();
    }

    private void initView() {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mMovieList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mMovieList.loadAble()) {
                    loadMoreData();
                }
            }
        });
        mMovieList.setItemAnimator(new DefaultItemAnimator());
        //屏蔽掉默认的动画，房子刷新时图片闪烁
        mMovieList.getItemAnimator().setChangeDuration(0);
        mMovieList.setLayoutManager(mStaggeredGridLayoutManager);
        mSrlRefresh.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.black));
        mSrlRefresh.setOnRefreshListener(this);
        mSrlRefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refreshData();
        mPresenter.loadCache();
        mMovieList.addOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, BaseItem baseItem, View view) {
            }
        });
        View footerView = mMovieList.getFooterView();
        if (footerView != null) {
            footerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadMoreData();
                }
            });
        }
    }

    @Override
    public void showProgressBar() {
        //显示加载进度条
        if (!mSrlRefresh.isRefreshing()) {
            mSrlRefresh.setRefreshing(true);
        }
    }

    @Override
    public void hideProgressBar() {
        //隐藏加载进度条
        mSrlRefresh.setRefreshing(false);
    }

    @Override
    public void loadMoreData() {
        if (!loading) {
            //加载要显示的数据
            mPresenter.loadMoreData();
            loading = true;
        }
    }

    @Override
    public void refreshData() {
        //刷新数据
        mPresenter.refreshData();
    }

    @Override
    public void loadSuccessed(ArrayList<BaseItem> movieSubjects) {
        loading = false;
        mMovieListAdapter.addBaseDatas(movieSubjects);
    }

    @Override
    public void loadFail(String errMsg) {
        //SnackBar提示错误信息
        loading = false;
    }

    @Override
    public void refreshSucceed(ArrayList<BaseItem> movieSubjects) {
        //如果是刚进入时刷新则新建一个Adapter，否则只是更新数据源
        if (mMovieListAdapter == null) {
            mMovieListAdapter = new MovieListAdapter(this);
            mMovieListAdapter.setBaseDatas(movieSubjects);
            mMovieList.setAdapter(mMovieListAdapter);
        } else {
            mMovieListAdapter.setBaseDatas(movieSubjects);
        }
    }

    @Override
    public void refreshFail(String errMsg) {
        //SnackBar提示错误信息

    }

    @Override
    public void onRefresh() {
        refreshData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden && mSrlRefresh.isRefreshing()) { // 隐藏的时候停止 SwipeRefreshLayout 转动
            mSrlRefresh.setRefreshing(false);
        }
        if (!hidden) {
            subscribeEvent();
        } else {
        }
    }

    @Override
    public void bindPresenter() {
        if (mPresenter == null) {
            mPresenter = new DouBanMoviePresenter();
        }
        mPresenter.bindView(this);
    }

    @Override
    public void unbindPresenter() {
        mPresenter.unbindView();
    }

    @Override
    public void destoryPresenter() {
        mPresenter.onDestory();
    }

    private void subscribeEvent() {
//        if (mDisposable != null) {
//            mDisposable.dispose();
//        }
//        RxBus.getDefault()
//                .toObservableWithCode(RxConstants.BACK_PRESSED_CODE, String.class)
//                .subscribeWith(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        mDisposable = d;
//                    }
//
//                    @Override
//                    public void onNext(String value) {
//                        if (value.equals(RxConstants.BACK_PRESSED_DATA) && mMovieList != null) {
//                            //滚动到顶部
//                            mStaggeredGridLayoutManager.smoothScrollToPosition(mMovieList, null, 0);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        subscribeEvent();
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}

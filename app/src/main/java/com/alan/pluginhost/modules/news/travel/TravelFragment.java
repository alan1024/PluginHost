package com.alan.pluginhost.modules.news.travel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alan.pluginhost.BaseFragment;
import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;
import com.alan.pluginhost.magicrecyclerView.MagicRecyclerView;
import com.alan.pluginhost.modules.news.NewsBean;
import com.alan.pluginhost.modules.news.NewsContract;
import com.alan.pluginhost.modules.news.NewsListAdapter;
import com.alan.pluginhost.rxbus.RxBus;
import com.alan.pluginhost.rxbus.RxConstants;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class TravelFragment extends BaseFragment implements NewsContract.View, SwipeRefreshLayout.OnRefreshListener, BaseRecyclerAdapter.OnItemClickListener {
    MagicRecyclerView mNewsRecycler;
    SwipeRefreshLayout mRefresh;
    TextView mEmptyMsg;
    private NewsContract.Presenter mPresenter;
    private NewsListAdapter mAdapter;
    private boolean loading = false;
    private Disposable mDisposable;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.activity_main, null, false);
        bindPresenter();
        mLinearLayoutManager = new LinearLayoutManager(this.getContext());
        mNewsRecycler.setLayoutManager(mLinearLayoutManager);
        //屏蔽掉默认的动画，房子刷新时图片闪烁
        mNewsRecycler.getItemAnimator().setChangeDuration(0);
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
        mRefresh.setRefreshing(false);
        unbindPresenter();
        onHiddenChanged(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destoryPresenter();
        mAdapter = null;
    }

    private void initView() {
        mNewsRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mNewsRecycler.refreshAble()) {
                    mRefresh.setEnabled(true);
                }
                if (mNewsRecycler.loadAble()) {
                    loadMoreNews();
                }
            }
        });
        mRefresh.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.white_FFFFFF));
        mRefresh.setOnRefreshListener(this);
        mRefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mRefresh.setRefreshing(true);
        refreshNews();
        mPresenter.loadCache();
        View footer = mNewsRecycler.getFooterView();
        if (footer != null) {
            footer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadMoreNews();
                }
            });
        }
    }

    @Override
    public void showRefreshBar() {
        mRefresh.setRefreshing(true);
    }

    @Override
    public void hideRefreshBar() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public void refreshNews() {
        mPresenter.refreshNews();
    }

    @Override
    public void refreshNewsFail(String errorMsg) {
        if (mAdapter == null) {
            mEmptyMsg.setVisibility(View.VISIBLE);
            mNewsRecycler.setVisibility(View.INVISIBLE);
            mRefresh.requestFocus();
        }
    }

    @Override
    public void refreshNewsSuccessed(ArrayList<BaseItem> topNews) {
        if (topNews == null || topNews.size() <= 0) {
            mEmptyMsg.setVisibility(View.VISIBLE);
            mNewsRecycler.setVisibility(View.INVISIBLE);
            mRefresh.requestFocus();
        } else {
            mEmptyMsg.setVisibility(View.GONE);
            mNewsRecycler.setVisibility(View.VISIBLE);
        }
        if (mAdapter == null) {
            mAdapter = new NewsListAdapter(this);
            mAdapter.setBaseDatas(topNews);
            mNewsRecycler.setAdapter(mAdapter);
            //实质是是对 adapter 设置点击事件所以需要在设置 adapter 之后调用
            mNewsRecycler.addOnItemClickListener(this);
        } else {
            mAdapter.setBaseDatas(topNews);
        }
        mNewsRecycler.showFooter();
    }

    @Override
    public void loadMoreNews() {
        if (!loading) {
            mPresenter.loadMore();
            loading = true;
        }
    }

    @Override
    public void loadMoreFail(String errorMsg) {
        loading = false;
    }

    @Override
    public void loadMoreSuccessed(ArrayList<BaseItem> topNewses) {
        loading = false;
        mAdapter.addBaseDatas(topNewses);
    }

    @Override
    public void loadAll() {
        mNewsRecycler.hideFooter();
    }

    @Override
    public void onRefresh() {
        refreshNews();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden && mRefresh.isRefreshing()) { // 隐藏的时候停止 SwipeRefreshLayout 转动
            mRefresh.setRefreshing(false);
        }
        if (!hidden) {
            subscribeEvent();
        } else {
            if (mDisposable != null && !mDisposable.isDisposed()) {
                mDisposable.dispose();
            }
        }
    }

    @Override
    public void onItemClick(int position, BaseItem data, View view) {
        //跳转到其他界面
        NewsBean topNews = (NewsBean) data.getData();
        Bundle bundle = new Bundle();
    }

    @Override
    public void bindPresenter() {
        if (mPresenter == null) {
            mPresenter = new TravelPresenter();
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
        if (mDisposable != null) {
            mDisposable.dispose();
        }
        RxBus.getDefault()
                .toObservableWithCode(RxConstants.BACK_PRESSED_CODE, String.class)
                .subscribeWith(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(String value) {
                        if (value.equals(RxConstants.BACK_PRESSED_DATA) && mNewsRecycler != null) {
                            //滚动到顶部
                            mLinearLayoutManager.smoothScrollToPosition(mNewsRecycler, null, 0);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        subscribeEvent();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

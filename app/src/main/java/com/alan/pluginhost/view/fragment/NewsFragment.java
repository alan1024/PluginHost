package com.alan.pluginhost.view.fragment;

import android.content.Intent;
import android.view.View;

import com.alan.pluginhost.R;
import com.alan.pluginhost.adapter.NewsListAdapter;
import com.alan.pluginhost.delegate.NewsFragmentDelegate;
import com.alan.pluginhost.delegate.SwipeRefreshAndLoadMoreCallBack;
import com.alan.pluginhost.model.entity.NewsBody;
import com.alan.pluginhost.model.entity.ShowApiNews;
import com.alan.pluginhost.model.entity.ShowApiResponse;
import com.alan.pluginhost.model.news.NewsModel;
import com.alan.pluginhost.model.news.NewsModelImpl;
import com.alan.pluginhost.mvp_frame.presenter.FragmentPresenter;
import com.alan.pluginhost.utils.ToastUtils;
import com.alan.pluginhost.view.activity.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends FragmentPresenter<NewsFragmentDelegate> implements SwipeRefreshAndLoadMoreCallBack {
    private NewsModel mNewsModel;
    private int mPageNum = 1;
    private NewsListAdapter mAdapter;

    //新闻数据列表
    private List<NewsBody> mNews = new ArrayList<>();

//    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    protected Class<NewsFragmentDelegate> getDelegateClass() {
        return NewsFragmentDelegate.class;
    }


    @Override
    protected void initData() {
        super.initData();
        mNewsModel = new NewsModelImpl();

        mAdapter = new NewsListAdapter(getActivity(), mNews);
        viewDelegate.setListAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new NewsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NewsBody item = mNews.get(position);
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                if ((item.getImageurls() != null && item.getImageurls().size() > 0)) {
                    intent.putExtra(NewsDetailActivity.ARG_NEWS_PIC, item.getImageurls().get(0).getUrl());
                }
                intent.putExtra(NewsDetailActivity.ARG_NEWS_URL, item.getLink());
                intent.putExtra(NewsDetailActivity.ARG_NEWS_TITLE, item.getTitle());
                startActivity(intent);
            }
        });

        //注册下拉刷新
        viewDelegate.registerSwipeRefreshCallBack(this);
        //注册加载更多
        viewDelegate.registerLoadMoreCallBack(this, mAdapter);

        netNewsList(true);
    }

    /**
     * 从网络加载数据列表
     *
     * @param isRefresh 是否刷新
     */
    private void netNewsList(final boolean isRefresh) {
//        viewDelegate.showLoading();
        if (isRefresh) {
            mPageNum = 1;
        } else {
            mPageNum++;
        }

    }

    private void failure(ShowApiResponse<ShowApiNews> response) {
        if (response != null) {
            ToastUtils.showShort(response.getShowapi_res_error());
        }
        viewDelegate.showError(R.string.load_error, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netNewsList(true);
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void refresh() {
        netNewsList(true);
    }

    /**
     * 加载更多
     */
    @Override
    public void loadMore() {
        netNewsList(false);
    }
}

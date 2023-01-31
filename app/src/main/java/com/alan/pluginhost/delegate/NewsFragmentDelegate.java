package com.alan.pluginhost.delegate;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.adapter.NewsListAdapter;
import com.alan.pluginhost.view.LoadingView;


public class NewsFragmentDelegate extends BaseRecyclerViewDelegate implements LoadingView {
    /**
     * 用于加载更多的列表布局管理器
     */
    private LinearLayoutManager mRecycleViewLayoutManager;

    @Override
    void initRecyclerView() {
        //设置分割线
//        recyclerview.addItemDecoration(new ListItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setHasFixedSize(true);
        mRecycleViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mRecycleViewLayoutManager);
    }

    @Override
    boolean setFloatingActionMenuVisible() {
        return false;
    }

    /**
     * 设置加载更多接口
     *
     * @param callBack 加载更多的回调
     */
    public void registerLoadMoreCallBack(final SwipeRefreshAndLoadMoreCallBack callBack, final NewsListAdapter adapter) {
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int lastVisibleItem;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mRecycleViewLayoutManager.findLastVisibleItemPosition();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == adapter.getItemCount()
                        && adapter.isShowFooter()) {
                    //加载更多
                    callBack.loadMore();
                }
            }
        });
    }
}

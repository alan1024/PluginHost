package com.alan.pluginhost.delegate;

public interface SwipeRefreshAndLoadMoreCallBack {
    /**
     * 下拉刷新
     */
    void refresh();

    /**
     * 加载更多
     */
    void loadMore();
}

package com.alan.pluginhost.delegate;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alan.pluginhost.R;
import com.alan.pluginhost.common.Constants;
import com.alan.pluginhost.mvp_frame.view.AppDelegate;
import com.alan.pluginhost.view.LoadingView;
import com.alan.pluginhost.widget.ProgressLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public abstract class BaseRecyclerViewDelegate extends AppDelegate implements LoadingView {
    @BindView(R.id.progress_layout)
    ProgressLayout progress_layout;//进度条布局（通用，可实现错误按钮，点击重试）
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipe_refresh_layout;//下拉刷新控件
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    protected List<FloatingActionButton> mFloatingActionButtons;//悬浮菜单选项数组

    /**
     * 初始化recyclerview，必须重写
     */
    abstract void initRecyclerView();

    /**
     * 设置悬浮菜单是否显示，必须重写
     */
    abstract boolean setFloatingActionMenuVisible();

    @Override
    public int getRootLayoutId() {
        return R.layout.layout_base_recyclerview;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        initSwipeRefreshLayout();
        initRecyclerView();
        initFloatingActionMenu();
    }

    /**
     * 初始化悬浮菜单
     */
    private void initFloatingActionMenu() {
        mFloatingActionButtons = new ArrayList<>();

    }

    /**
     * 初始化下拉刷新控件
     */
    private void initSwipeRefreshLayout() {
        swipe_refresh_layout.setColorSchemeResources(Constants.colors);//设置下拉刷新控件变换的四个颜色
    }

    /**
     * 设置是否隐藏悬浮菜单选项卡
     *
     * @param animate 是否动画
     */
    public void hideMenu(boolean animate) {
    }

    /**
     * 设置下拉刷新接口
     *
     * @param callBack 下拉刷新的回调接口
     */
    public void registerSwipeRefreshCallBack(final SwipeRefreshAndLoadMoreCallBack callBack) {

    }

    public void setListAdapter(RecyclerView.Adapter adapter) {
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        progress_layout.showLoading();
    }

    @Override
    public void showContent() {
        swipe_refresh_layout.setRefreshing(false);
        if (!progress_layout.isContent()) {
            progress_layout.showContent();
        }
    }

    @Override
    public void showError(int messageId, View.OnClickListener listener) {
        swipe_refresh_layout.setRefreshing(false);
        if (!progress_layout.isError()) {
            progress_layout.showError(messageId, listener);
        }
    }
}

package com.alan.pluginhost.recylerview.refreshload;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alan.pluginhost.recylerview.widget.LoadRefreshRecyclerView;
import com.alan.pluginhost.recylerview.widget.RefreshViewCreator;

public class DefaultRefreshCreator extends RefreshViewCreator {
    // 加载数据的ImageView
    private ImageView mRefreshIv;

    @Override
    public View getRefreshView(Context context, ViewGroup parent) {
        View refreshView = null;
        mRefreshIv = null;
        return refreshView;
    }

    @Override
    public void onPull(int currentDragHeight, int refreshViewHeight, int currentRefreshStatus) {
        if (currentRefreshStatus == LoadRefreshRecyclerView.LOAD_STATUS_PULL_DOWN_REFRESH) {
        }
        if (currentRefreshStatus == LoadRefreshRecyclerView.LOAD_STATUS_LOOSEN_LOADING) {
        }
    }

    @Override
    public void onRefreshing() {
        ((AnimationDrawable) mRefreshIv.getBackground()).start();
    }

    @Override
    public void onStopRefresh() {
        // 停止加载的时候清除动画
        mRefreshIv.setRotation(0);
        ((AnimationDrawable) mRefreshIv.getBackground()).stop();
        mRefreshIv.clearAnimation();
    }
}

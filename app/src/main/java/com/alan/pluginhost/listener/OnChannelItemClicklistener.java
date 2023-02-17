package com.alan.pluginhost.listener;

import android.view.View;

public interface OnChannelItemClicklistener {
    /**
     * 已选中频道item点击监听回调
     *
     * @param itemView
     * @param position
     */
    public void onAddedChannelItemClick(View itemView, int position);

    /**
     * 未选中频道item点击监听回调
     *
     * @param itemView
     * @param position
     */
    public void onUnAddedChannelItemClick(View itemView, int position);

    /**
     * item icon 点击监听回调
     *
     * @param itemView
     * @param position
     */
    public void onItemDrawableClickListener(View itemView, int position);
}

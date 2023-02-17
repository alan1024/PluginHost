package com.alan.pluginhost.listener;

import android.view.View;

import com.alan.pluginhost.bean.ChannelItem;

import java.util.ArrayList;

public interface UserActionListener {
    /**
     * 拖动完成
     *
     * @param fromPos       拖动起始位置
     * @param toPos         拖动结束位置
     * @param addedChannels 拖动完成后频道数据集合
     */
    public void onMoved(int fromPos, int toPos, ArrayList<ChannelItem> addedChannels);

    /**
     * 侧滑删除后
     *
     * @param position        删除的positon
     * @param itemView        当前拖动itemview
     * @param addedChannels   删除positon项后的已添加频道数据集合
     * @param unAddedChannels 删除positon项后的未添加频道数据集合
     */
    public void onSwiped(int position, View itemView, ArrayList<ChannelItem> addedChannels, ArrayList<ChannelItem> unAddedChannels);
}

package com.alan.pluginhost.database;


import com.alan.pluginhost.bean.Channel;

import java.util.ArrayList;
import java.util.List;

public class ChannelDao {

    /**
     * 获取所有频道
     *
     * @return
     */
    public static List<Channel> getChannels() {
        return null;
    }


    /**
     * 保存所有频道
     *
     * @param channels
     */
    public static void saveChannels(final List<Channel> channels) {
        if (channels == null) return;
        if (channels.size() > 0) {
            final List<Channel> channelList = new ArrayList<>();
            channelList.addAll(channels);

        }
    }

    /**
     * 清空所有频道
     */
    public static void cleanChanels() {

    }
}

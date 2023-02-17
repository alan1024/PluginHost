package com.alan.pluginhost.bean;

import java.util.ArrayList;

public class GroupItem {
    public String category;
    private ArrayList<ChannelItem> channelItems = new ArrayList<>();

    public ArrayList<ChannelItem> getChannelItems() {
        return channelItems;
    }

    public void setChannelItems(ArrayList<ChannelItem> channelItems) {
        this.channelItems = channelItems;
    }

    public void addChanelItem(ChannelItem item) {
        if (channelItems != null) {
            channelItems.add(item);
        }
    }

    ;
}

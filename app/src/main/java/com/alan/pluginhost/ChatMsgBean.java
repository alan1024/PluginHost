package com.alan.pluginhost;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class ChatMsgBean implements MultiItemEntity {

    public static final int COMING = 0;
    public static final int SENDING = 1;

    public String info;
    public String date;

    @Override
    public int getItemType() {
        return 0;
    }
}

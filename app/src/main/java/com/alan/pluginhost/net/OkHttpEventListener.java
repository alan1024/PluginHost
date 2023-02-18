package com.alan.pluginhost.net;

import java.util.EventListener;

public class OkHttpEventListener implements EventListener {

    private OkHttpEvent mOkHttpEvent;

    public OkHttpEventListener() {
        super();
        mOkHttpEvent = new OkHttpEvent();
    }


}

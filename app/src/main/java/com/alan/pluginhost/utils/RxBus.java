package com.alan.pluginhost.utils;


public class RxBus {

    private volatile static RxBus sInstance;

    private RxBus() {
    }

    public static RxBus get() {
        if (sInstance == null) {
            synchronized (RxBus.class) {
                if (sInstance == null) {
                    sInstance = new RxBus();
                }
            }
        }
        return sInstance;
    }

}

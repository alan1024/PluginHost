package com.alan.pluginhost.crawler;


import com.alan.pluginhost.extractor.URL;

import java.util.logging.Logger;


public class Redis {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Redis() {
        try {
        } catch (Exception e) {
        }
    }

    private final static Redis INSTANCE = new Redis();

    public static Redis getInstance() {
        return INSTANCE;
    }

    public boolean hasFetched(URL u) {
        return false;
    }

    public void add(URL u) {
    }
}

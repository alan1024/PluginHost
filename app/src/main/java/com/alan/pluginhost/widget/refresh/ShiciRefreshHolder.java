package com.alan.pluginhost.widget.refresh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiZhen
 * @date 2020/5/10
 */
public class ShiciRefreshHolder {

    private static ShiciRefreshHolder instance = null;
    private static final int MAX_SIZE = 3;

    public static ShiciRefreshHolder instance() {
        if (instance == null) {
            instance = new ShiciRefreshHolder();
        }
        return instance;
    }


    private final List<String> mCache = new ArrayList<>(MAX_SIZE);

    private ShiciRefreshHolder() {
        request();
    }

    private void request() {
        if (mCache.size() >= MAX_SIZE) {
            return;
        }

    }

    public void refresh() {
        if (mCache.size() >= 2) {
            mCache.remove(0);
        }
        request();
    }

    public String get() {
        if (mCache.isEmpty()) {
            return null;
        }
        return mCache.get(0);
    }

}

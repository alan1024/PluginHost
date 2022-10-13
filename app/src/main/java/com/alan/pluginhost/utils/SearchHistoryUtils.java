package com.alan.pluginhost.utils;

import android.text.TextUtils;

import java.util.List;

/**
 * @author CuiZhen
 * @date 2019/5/18
 * GitHub: https://github.com/goweii
 */
public class SearchHistoryUtils {

    private static final String SP_NAME = "search_history";
    private static final String KEY_HISTORY = "KEY_HISTORY";

    private final SPUtils mSPUtils = SPUtils.newInstance(SP_NAME);

    public static SearchHistoryUtils newInstance() {
        return new SearchHistoryUtils();
    }

    private SearchHistoryUtils() {
    }

    public void save(List<String> historys) {
        if (historys == null || historys.isEmpty()) {
            mSPUtils.clear();
        }
    }

    public List<String> get() {
        String json = mSPUtils.get(KEY_HISTORY, "");
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            String json12 = mSPUtils.get(KEY_HISTORY, "");
        } catch (Exception e) {
            mSPUtils.clear();
            return null;
        }
        return null;
    }
}

package com.alan.pluginhost.utils;

import com.alan.pluginhost.utils.web.HostInterceptUtils;

/**
 * @author CuiZhen
 * @date 2019/5/18
 * GitHub: https://github.com/goweii
 */
public class SettingUtils {

    private static final String SP_NAME = "setting";
    private static final String KEY_SYSTEM_THEME = "KEY_SYSTEM_THEME";
    private static final String KEY_DARK_THEME = "KEY_DARK_THEME";
    private static final String KEY_SHOW_READ_LATER = "KEY_SHOW_READ_LATER";
    private static final String KEY_SHOW_READ_LATER_NOTIFICATION = "KEY_SHOW_READ_LATER_NOTIFICATION";
    private static final String KEY_SHOW_READ_RECORD = "KEY_SHOW_READ_RECORD";
    private static final String KEY_SHOW_TOP = "KEY_SHOW_TOP";
    private static final String KEY_SHOW_BANNER = "KEY_SHOW_BANNER";
    private static final String KEY_HIDE_ABOUT_ME = "KEY_HIDE_ABOUT_ME";
    private static final String KEY_HIDE_OPEN = "KEY_HIDE_OPEN";
    private static final String KEY_WEB_SWIPE_BACK_EDGE = "KEY_WEB_SWIPE_BACK_EDGE";
    private static final String KEY_RV_ANIM = "KEY_RV_ANIM";
    private static final String KEY_URL_INTERCEPT_TYPE = "KEY_URL_INTERCEPT_TYPE";
    private static final String KEY_HOST_WHITE = "KEY_HOST_WHITE";
    private static final String KEY_HOST_BLACK = "KEY_HOST_BLACK";
    private static final String KEY_SEARCH_HISTORY_MAX_COUNT = "KEY_SEARCH_HISTORY_MAX_COUNT";
    private static final String KEY_UPDATE_IGNORE_DURATION = "KEY_UPDATE_IGNORE_DURATION";

    private final SPUtils mSPUtils = SPUtils.newInstance(SP_NAME);

    private boolean mSystemTheme = true;
    private boolean mDarkTheme = false;
    private boolean mShowReadLaterNotification = true;
    private boolean mShowTop = true;
    private boolean mShowBanner = true;
    private int mUrlInterceptType = HostInterceptUtils.TYPE_NOTHING;
    private int mSearchHistoryMaxCount = 100;
    private long mUpdateIgnoreDuration = 1 * 24 * 60 * 60 * 1000L;

    private static class Holder {
        private static final SettingUtils INSTANCE = new SettingUtils();
    }

    public static SettingUtils getInstance() {
        return Holder.INSTANCE;
    }


    public long getUpdateIgnoreDuration() {
        return mUpdateIgnoreDuration;
    }
}

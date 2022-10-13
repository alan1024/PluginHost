package com.alan.pluginhost.utils;

/**
 * @author CuiZhen
 * @date 2019/5/18
 * GitHub: https://github.com/goweii
 */
public class ADUtils {
    private static final String SP_NAME = "ad";
    private static final String KEY_AD = "KEY_AD";

    private final SPUtils mSPUtils = SPUtils.newInstance(SP_NAME);

    private static class Holder {
        private static final ADUtils INSTANCE = new ADUtils();
    }

    public static ADUtils getInstance() {
        return Holder.INSTANCE;
    }

    private ADUtils() {
    }


    public void setAdShown() {
        mSPUtils.save(KEY_AD, System.currentTimeMillis());
    }
}

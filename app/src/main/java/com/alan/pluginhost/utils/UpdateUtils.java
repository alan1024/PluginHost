package com.alan.pluginhost.utils;

import java.util.Date;

/**
 * @author CuiZhen
 * @date 2019/5/19
 * GitHub: https://github.com/goweii
 */
public class UpdateUtils {
    private static final String SP_NAME = "update";
    private static final String KEY_LAST_CHECK_TIME = "KEY_LAST_CHECK_TIME";
    private static final String KEY_VERSION_CODE = "KEY_VERSION_CODE";
    private static final String KEY_TIME = "KEY_TIME";
    private static final String KEY_BETA_VERSION_CODE = "KEY_BETA_VERSION_CODE";
    private static final String KEY_BETA_VERSION_NAME = "KEY_BETA_VERSION_NAME";
    private static final String KEY_BETA_TIME = "KEY_TEST_TIME";

    private static final String BETA = "beta";

    private final SPUtils mSPUtils = SPUtils.newInstance(SP_NAME);

    public static UpdateUtils newInstance() {
        return new UpdateUtils();
    }

    private UpdateUtils() {
    }

    public void ignore(int versionCode) {
        mSPUtils.save(KEY_VERSION_CODE, versionCode);
        mSPUtils.save(KEY_TIME, System.currentTimeMillis());
    }


    public boolean isTodayChecked() {
        long last = mSPUtils.get(KEY_LAST_CHECK_TIME, 0L);
        long curr = System.currentTimeMillis();
        mSPUtils.save(KEY_LAST_CHECK_TIME, curr);
        Date lastDate = new Date(last);
        Date currDate = new Date(curr);
        return lastDate.getYear() == currDate.getYear() &&
                lastDate.getMonth() == currDate.getMonth() &&
                lastDate.getDay() == currDate.getDay();
    }
}

package com.alan.pluginhost.utils.cdkey;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * @author CuiZhen
 * @date 2020/1/1
 * GitHub: https://github.com/goweii
 */
public class CDKeyUtils {
    private static final String SP_NAME = "cdkey";
    private static final String KEY_USERID = "userid";
    private static final String KEY_CDKEY = "cdkey";

    private static class Holder {
        private static final CDKeyUtils sInstance = new CDKeyUtils();
    }

    public static CDKeyUtils getInstance() {
        return Holder.sInstance;
    }

    @Nullable
    private final CDKey mCDKey;

    private CDKeyUtils() {
        mCDKey = newCDKey();
    }

    public void isActive() {
    }

    public void set(String cdKey) {

    }

    @NonNull
    public String get() {
        return "";
    }

    @NonNull
    public String create(@NonNull String userId) {
        if (mCDKey == null) return "";
        return mCDKey.create(userId);
    }

    public boolean check(@NonNull String userId, @NonNull String cdkey) {
        return false;
    }

    private CDKey newCDKey() {
        try {
            return null;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}

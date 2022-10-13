package com.alan.pluginhost.utils.cdkey;

import androidx.annotation.NonNull;

/**
 * @author CuiZhen
 * @date 2020/1/1
 * GitHub: https://github.com/goweii
 */
public interface CDKey {
    @NonNull
    String create(@NonNull String userId);

    boolean check(@NonNull String userId, @NonNull String cdkey);
}

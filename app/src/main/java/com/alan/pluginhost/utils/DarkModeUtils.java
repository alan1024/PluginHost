package com.alan.pluginhost.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * @author CuiZhen
 * @date 2020/2/17
 * GitHub: https://github.com/goweii
 */
public class DarkModeUtils {
    public static boolean isDarkMode(Configuration config) {
        int uiMode = config.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return uiMode == Configuration.UI_MODE_NIGHT_YES;
    }

    public static boolean isDarkMode(Context context) {
        return isDarkMode(context.getResources().getConfiguration());
    }

    public static void initDarkMode() {

    }
}

package com.alan.pluginhost.util;

import android.app.Activity;

import com.alan.pluginhost.R;


public class ThemeTool {


    public static void changeTheme(Activity activity) {
        if (PrefUtils.isDarkMode()) {
            activity.setTheme(R.style.Base_Theme_AppCompat);
        }
    }
}

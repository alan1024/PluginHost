package com.alan.pluginhost.utils;

public class ThemeUtils {
    private static final String THEME_NAME_RED = "red";
    private static final String THEME_NAME_GREEN = "green";
    private static final String THEME_NAME_PINK = "pink";
    private static final String THEME_NAME_GOLD = "gold";


    private static final String SP_NAME = "launcher_theme";
    private static final String SP_KEY_WILL_INSTALL = "willInstall";
    private static SPUtils sSPUtils = null;


    public static boolean isWillInstall() {
        return sSPUtils.get(SP_KEY_WILL_INSTALL, false);
    }

    public static void setWillInstall() {
        sSPUtils.save(SP_KEY_WILL_INSTALL, true);
    }

    public static void setNotInstall() {
        sSPUtils.save(SP_KEY_WILL_INSTALL, false);
    }

}

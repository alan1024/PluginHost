package com.alan.pluginhost;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.common.internal.Constants;


public class SPUtils {
    private static SharedPreferences sp;

    public static SharedPreferences instance(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.ACTION_LOAD_IMAGE, Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static void clearAllData() {
        checkSp();
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    private SharedPreferences.Editor edit() {
        checkSp();
        return sp.edit();
    }

    private static void checkSp() {
        if (sp == null) {
            sp = instance(HostApp.getInstance());
        }
    }
}

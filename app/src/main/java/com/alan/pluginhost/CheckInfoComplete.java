package com.alan.pluginhost;

import android.content.Context;
import android.text.TextUtils;

public class CheckInfoComplete {

    public static boolean check(Context context) {
        String currentNickname = SharedPrerensUtils.getString(context, Config.NICKNAME_KEY);
        String myHeadUrl = SharedPrerensUtils.getString(context, Config.HEAD_URL_KEY);
        String mySex = SharedPrerensUtils.getString(context, Config.SEX_KEY);
        if (!TextUtils.isEmpty(currentNickname) && !TextUtils.isEmpty(mySex) && !TextUtils.isEmpty(myHeadUrl)) {
            return true;
        }
        return false;
    }
}

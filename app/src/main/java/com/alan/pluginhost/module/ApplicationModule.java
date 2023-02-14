package com.alan.pluginhost.module;

import android.content.Context;



public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    Context provideContext() {
        return mContext;
    }
}

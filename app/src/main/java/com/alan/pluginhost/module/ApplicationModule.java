package com.alan.pluginhost.module;

import android.content.Context;

import com.google.android.datatransport.runtime.dagger.Provides;


public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}

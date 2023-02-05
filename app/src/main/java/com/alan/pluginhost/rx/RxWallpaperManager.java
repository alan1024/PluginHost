package com.alan.pluginhost.rx;

import android.app.WallpaperManager;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

import rx.Observable;


public class RxWallpaperManager {

    public static Observable<Void> setStream(Context context, InputStream stream) {
        return Observable.defer(() -> {
            try {
                WallpaperManager.getInstance(context).setStream(stream);
                return Observable.just(null);
            } catch (IOException e) {
                return Observable.error(e);
            }
        });
    }

}

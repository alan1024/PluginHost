package com.alan.pluginhost.utils.ijkplayer.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;


public class MediaPlayerService extends Service {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MediaPlayerService.class);
        return intent;
    }

    public static void intentToStart(Context context) {
        context.startService(newIntent(context));
    }

    public static void intentToStop(Context context) {
        context.stopService(newIntent(context));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

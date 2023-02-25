package com.alan.pluginhost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CommentBroadcast extends BroadcastReceiver {
    public CommentBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, CommentService.class);
        context.startService(i);
    }
}

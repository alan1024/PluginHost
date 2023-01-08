package com.alan.pluginhost.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class JpushReceiver extends BroadcastReceiver {

    public static final String IS_FROM_JPUSH = "isFromJpush";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();


    }
}

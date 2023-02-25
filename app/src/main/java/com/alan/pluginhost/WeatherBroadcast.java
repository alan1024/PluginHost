package com.alan.pluginhost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WeatherBroadcast extends BroadcastReceiver {
    public WeatherBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, WeatherService.class);
        context.startService(i);

    }
}

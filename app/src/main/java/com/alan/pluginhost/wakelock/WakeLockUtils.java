package com.alan.pluginhost.wakelock;

import android.content.Context;
import android.os.PowerManager;

public class WakeLockUtils {
    private static PowerManager.WakeLock sWakeLock;

    public static void acquire(Context context) {
        if (sWakeLock == null) {
            sWakeLock = createWakeLock(context);
        }
        if (sWakeLock != null && !sWakeLock.isHeld()) {
            //唤醒CPU
            sWakeLock.acquire();
        }
    }

    public static void release() {
        if (sWakeLock != null && sWakeLock.isHeld()) {
            sWakeLock.release();
            sWakeLock = null;
        }
    }

    private static PowerManager.WakeLock createWakeLock(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm != null) {
            return null;
        }
        return null;
    }
}

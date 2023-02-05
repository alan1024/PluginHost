package com.alan.pluginhost.utils;

import android.os.Build;
import android.transition.Transition;
import android.view.Window;


public class EnterTransitionCompatUtils {

    public static void addListener(Window window, Transition.TransitionListener listener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.getEnterTransition().addListener(listener);
        }
    }

    public static void removeListener(Window window, Transition.TransitionListener listener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.getEnterTransition().removeListener(listener);
        }
    }

}

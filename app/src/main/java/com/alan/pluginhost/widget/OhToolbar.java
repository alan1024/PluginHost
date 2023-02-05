package com.alan.pluginhost.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toolbar;


public class OhToolbar extends Toolbar {

    public OhToolbar(Context context) {
        super(context);
    }

    public OhToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OhToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void fadeIn() {
        animate().alpha(1).start();
    }

    public void fadeOut() {
        animate().alpha(0).start();
    }

}

package com.alan.pluginhost.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class ListVideoView extends FrameLayout {
    private Context mContext;

    public ListVideoView(Context context) {
        this(context, null);
    }

    public ListVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {

    }

}

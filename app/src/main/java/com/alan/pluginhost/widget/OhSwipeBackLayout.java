package com.alan.pluginhost.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.alan.pluginhost.R;
import com.alan.pluginhost.helper.ThemeHelper;
import com.alan.pluginhost.widget.sb.SwipeBackLayout;

public class OhSwipeBackLayout extends SwipeBackLayout {
    public OhSwipeBackLayout(Context context) {
        this(context, null);
    }

    public OhSwipeBackLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OhSwipeBackLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    private void init() {
        int color = ThemeHelper.resolveColor(this.getContext(), R.attr.colorPrimaryDark, 0xff00ff);
        setButtomColor(color);
        setBackText(getContext().getString(R.string.swipe_back_tip));
    }

    @Override
    protected void stop(int dir) {
        super.stop(dir);
    }
}

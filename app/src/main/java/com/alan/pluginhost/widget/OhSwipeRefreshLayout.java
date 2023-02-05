package com.alan.pluginhost.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alan.pluginhost.R;
import com.alan.pluginhost.utils.ThemeUtils;

public class OhSwipeRefreshLayout extends SwipeRefreshLayout {
    public OhSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public OhSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedValue colorAccent = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorAccent, colorAccent, true);
        setColorSchemeResources(colorAccent.resourceId);

        // 设置圆的样式
        if (ThemeUtils.getTheme(getContext()).tag.equals("dark")) {
            setProgressBackgroundColor(R.color.cardview_shadow_end_color);
        }
    }
}

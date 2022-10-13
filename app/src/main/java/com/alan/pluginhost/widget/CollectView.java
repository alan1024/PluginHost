package com.alan.pluginhost.widget;

import android.content.Context;
import android.util.AttributeSet;


/**
 * @author CuiZhen
 * @date 2019/5/15
 * GitHub: https://github.com/goweii
 */
public class CollectView {

    private OnClickListener mOnClickListener = null;
    private int mUncheckedColor;

    public CollectView(Context context) {
        this(context, null);
    }

    public CollectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollectView(Context context, AttributeSet attrs, int defStyleAttr) {
    }


    public interface OnClickListener {
        void onClick(CollectView v);
    }
}
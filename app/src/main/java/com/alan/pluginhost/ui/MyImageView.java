package com.alan.pluginhost.ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;


public class MyImageView extends AppCompatImageView {
    private OnMeasureListener listener;

    public void setOnMeasureListener(OnMeasureListener listener) {
        this.listener = listener;
    }

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (listener != null) {
            listener.onMeasureSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public interface OnMeasureListener {
        void onMeasureSize(int width, int height);
    }
}

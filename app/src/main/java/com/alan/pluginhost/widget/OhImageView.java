package com.alan.pluginhost.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class OhImageView extends ImageView {

    private int originalWidth;
    private int originalHeight;

    public OhImageView(Context context) {
        this(context, null);
    }

    public OhImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OhImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOriginalSize(int originalWidth, int originalHeight) {
        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (originalWidth > 0 && originalHeight > 0) {
            float ratio = (float) originalWidth / (float) originalHeight;

            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);

            if (width > 0) {
                height = (int) ((float) width / ratio);
            } else if (height > 0) {
                width = (int) ((float) height * ratio);
            }

            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }


}

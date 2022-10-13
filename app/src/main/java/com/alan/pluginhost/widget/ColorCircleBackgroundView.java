package com.alan.pluginhost.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class ColorCircleBackgroundView extends View {
    private int color1 = Color.TRANSPARENT;
    private int color2 = Color.TRANSPARENT;
    private int color3 = Color.TRANSPARENT;
    private int color4 = Color.TRANSPARENT;
    private int color5 = Color.TRANSPARENT;

    public ColorCircleBackgroundView(Context context) {
        this(context, null);
    }

    public ColorCircleBackgroundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorCircleBackgroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }
}

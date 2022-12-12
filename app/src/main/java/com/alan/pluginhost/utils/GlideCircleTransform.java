package com.alan.pluginhost.utils;

import android.content.Context;
import android.graphics.Bitmap;


public class GlideCircleTransform {

    public GlideCircleTransform(Context context) {

    }


    private static void circleCrop(Bitmap source) {
        if (source == null) return;
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
    }

}

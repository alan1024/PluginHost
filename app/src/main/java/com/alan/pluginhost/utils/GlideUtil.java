package com.alan.pluginhost.utils;

import android.content.Context;
import android.widget.ImageView;

import com.alan.pluginhost.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class GlideUtil {

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_holding)
                .error(R.mipmap.ic_error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }
}

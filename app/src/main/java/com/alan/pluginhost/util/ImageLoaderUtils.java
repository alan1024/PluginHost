package com.alan.pluginhost.util;

import android.content.Context;
import android.widget.ImageView;

import com.alan.pluginhost.R;
import com.bumptech.glide.Glide;

public class ImageLoaderUtils {

    public static void display(Context context, ImageView imageView, String url, int placeholder, int error) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).placeholder(placeholder)
                .error(error).crossFade().into(imageView);
    }

    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).crossFade().into(imageView);
    }


}

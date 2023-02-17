package com.alan.pluginhost.recylerview.loader;

import android.content.Context;
import android.widget.ImageView;

import com.alan.pluginhost.recylerview.adapter.ViewHolder;
import com.bumptech.glide.Glide;

public class GlideImageLoader extends ViewHolder.HolderImageLoader {
    public GlideImageLoader(String imagePath) {
        super(imagePath);
    }

    @Override
    public void displayImage(Context context, ImageView imageView, String imagePath) {
        Glide.with(context).load(imagePath).centerCrop().into(imageView);
    }
}

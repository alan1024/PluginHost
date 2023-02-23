package com.alan.pluginhost.modules.webphto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.alan.pluginhost.disklrucache.SecretUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImagesAdapter extends PagerAdapter {

    private Map<String, ImageView> mImageViewMap = new HashMap<>();
    private ArrayList<String> imageUrls;
    private Context mContext;

    public ImagesAdapter(Context context, ArrayList<String> urls) {
        imageUrls = urls;
        mContext = context;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageViewMap.get(SecretUtil.getMD5Result(imageUrls.get(position))));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = null;
        boolean hasImageView = mImageViewMap.containsKey(SecretUtil.getMD5Result(imageUrls.get(position)));
        if (hasImageView) {
            imageView = mImageViewMap.get(SecretUtil.getMD5Result(imageUrls.get(position)));
        } else {
            imageView = new ImageView(mContext);
            mImageViewMap.put(SecretUtil.getMD5Result(imageUrls.get(position)), imageView);
        }
        container.addView(imageView);
        return imageView;
    }
}

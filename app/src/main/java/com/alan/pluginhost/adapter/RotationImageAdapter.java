package com.alan.pluginhost.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.alan.pluginhost.model.SimpleArticleItem;
import com.alan.pluginhost.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class RotationImageAdapter extends PagerAdapter {

    private Context context;
    private List<SimpleArticleItem> articles;
    private List<ImageView> sdvs = new ArrayList<ImageView>();

    public RotationImageAdapter(Context context, List<SimpleArticleItem> articles) {
        this.context = context;
        if (articles == null || articles.size() == 0) {
            this.articles = new ArrayList<>();
        } else {
            this.articles = articles;
        }

        for (int i = 0; i < articles.size(); i++) {
            ImageView sdv = new ImageView(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            sdv.setLayoutParams(layoutParams);
            sdv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Uri uri = Uri.parse(Constant.BUCKET_HOST_NAME + articles.get(i).getImageUrls()[0]);
            sdv.setImageURI(uri);
            sdvs.add(sdv);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(sdvs.get(position));
        return sdvs.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(sdvs.get(position));
    }


    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }
}

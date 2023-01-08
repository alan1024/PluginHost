package com.alan.pluginhost.adapter;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.alan.pluginhost.model.ItemArticle;

import java.util.ArrayList;
import java.util.List;


public class HeaderAdapter extends PagerAdapter {
    private static final String LOG = "NEWS_LOG";

    private Activity context;
    private List<ItemArticle> articles;
    private List<ImageView> images = new ArrayList<ImageView>();


    public HeaderAdapter(Activity context, List<ItemArticle> articles) {
        this.context = context;
        if (articles == null || articles.size() == 0) {
            this.articles = new ArrayList<>();
        } else {
            this.articles = articles;
        }

        for (int i = 0; i < articles.size(); i++) {
            ImageView image = new ImageView(context);
            Uri uri = Uri.parse(articles.get(i).getImageUrl());
            image.setImageURI(uri);
            images.add(image);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.i(LOG, "in isViewFromObject view: " + view + " object: "
                + object + " equal: " + (view == object));
        return view == object;
    }
}

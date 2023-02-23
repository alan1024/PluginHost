package com.alan.pluginhost.modules.news;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;


public class NewsListAdapter extends BaseRecyclerAdapter {

    private Context mContext;
    private int widthPx;
    private int heighPx;

    public NewsListAdapter(Fragment fragment) {
        mContext = fragment.getContext();
        float width = mContext.getResources().getDimension(R.dimen.news_image_width);
        widthPx = (int) width;
        heighPx = widthPx * 3 / 4;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder holder, int RealPosition, BaseItem data) {
        if (holder instanceof ViewHolder) {
            NewsBean topNews = (NewsBean) data.getData();
            ((ViewHolder) holder).mNewsTitle.setText(topNews.getTitle());
            ((ViewHolder) holder).mSource.setText(topNews.getSource());
            String image = topNews.getImgsrc();//避免null引起Picasso崩溃
            if (!TextUtils.isEmpty(image)) {

            }
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mNewsImage;
        TextView mNewsTitle;
        TextView mSource;

        ViewHolder(View view) {
            super(view);
        }
    }
}

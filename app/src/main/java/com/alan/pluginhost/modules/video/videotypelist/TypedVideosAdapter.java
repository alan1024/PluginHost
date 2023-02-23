package com.alan.pluginhost.modules.video.videotypelist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;
import com.alan.pluginhost.modules.video.videotypelist.mvp.TypedVideos;


public class TypedVideosAdapter extends BaseRecyclerAdapter {
    private Context mContext;
    private int image_width;
    private int image_height;

    public TypedVideosAdapter(Context context) {
        mContext = context;
        float value = mContext.getResources().getDimension(R.dimen.fixed_icon_grid);
        image_width = (int) value * 3 / 4;
        image_height = (int) value;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, BaseItem data) {
        TypedVideos.ListBean listBean = (TypedVideos.ListBean) data.getData();
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.mTvVideoName.setText(listBean.getTitle());
        holder.mRbVideoStarts.setRating(listBean.getScore() / 2);
        holder.mTvVideoRate.setText(String.valueOf(listBean.getScore()));
        String image = listBean.getPic();
        if (!TextUtils.isEmpty(image)) {
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvVideo;
        TextView mTvVideoName;
        RatingBar mRbVideoStarts;
        TextView mTvVideoRate;
        TextView mTvAirTime;
        TextView mTvDuration;

        ViewHolder(View view) {
            super(view);
        }
    }
}

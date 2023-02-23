package com.alan.pluginhost.modules.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;

import java.util.ArrayList;


public class AlbumAdapter extends RecyclerView.Adapter {
    private ArrayList<ImageFileBean> mImageBeen;
    private Context mContext;

    public AlbumAdapter(ArrayList<ImageFileBean> imageBeen, Context context) {
        mImageBeen = imageBeen;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        mHolder.mTvFileCount.setText("" + mImageBeen.get(position).getImages().size() + "张");
        mHolder.mTvFileName.setText(mImageBeen.get(position).getFileName());

        mHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.OnItemClick(mImageBeen.get(position).getImages());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageBeen.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvCover;
        TextView mTvFileName;
        TextView mTvFileCount;
        RadioButton mRbCheckStatus;
        CardView mCardView;

        ViewHolder(View view) {
            super(view);
        }
    }

    public interface OnItemClickListener {
        void OnItemClick(ArrayList<String> images);
    }

    private OnItemClickListener mItemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}

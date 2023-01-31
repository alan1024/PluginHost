package com.alan.pluginhost.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.model.entity.PictureBody;
import com.alan.pluginhost.utils.GlideUtil;
import com.alan.pluginhost.widget.RatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureGridAdapter extends RecyclerView.Adapter {
    private List<PictureBody> mList;
    private Activity context;

    private OnImageClickListener mOnImageClickListener;

    public PictureGridAdapter(List<PictureBody> mList, Activity context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture_grid, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            PictureBody pictureBody = mList.get(position);
            GlideUtil.loadImage(context, pictureBody.getList().get(0).getMiddle(), viewHolder.iv_picture);
            viewHolder.tv_title.setText(pictureBody.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_picture)
        RatioImageView iv_picture;
        @BindView(R.id.tv_title)
        TextView tv_title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            iv_picture.setOriginalSize(50, 50);
            iv_picture.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnImageClickListener != null) {
                mOnImageClickListener.onImageClick(v, this.getPosition());
            }
        }
    }

    public void setOnImageClickListener(OnImageClickListener onItemClickListener) {
        this.mOnImageClickListener = onItemClickListener;
    }

    /**
     * 点击条目图片接口
     */
    public interface OnImageClickListener {
        void onImageClick(View view, int position);
    }
}

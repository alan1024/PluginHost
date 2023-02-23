package com.alan.pluginhost.modules.video.videodetail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;
import com.alan.pluginhost.modules.video.videodetail.mvp.CommentBean;


public class VideoCommentAdapter extends BaseRecyclerAdapter {
    private Context mContext;
    private int widthPx;
    private int heighPx;

    public VideoCommentAdapter(Fragment fragment) {
        mContext = fragment.getContext();
        float value = mContext.getResources().getDimension(R.dimen.fixed_icon_grid);
        widthPx = (int) value;
        heighPx = (int) value;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, BaseItem data) {
        CommentBean.ListBean comment = (CommentBean.ListBean) data.getData();
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).mTvLike.setText(String.valueOf(comment.getLikeNum()));
            ((ViewHolder) viewHolder).mTvUsername.setText(comment.getPhoneNumber());
            ((ViewHolder) viewHolder).mTvCommentText.setText(comment.getMsg());
            ((ViewHolder) viewHolder).mTvTimeText.setText(comment.getTime());
            String image = comment.getUserPic();
            if (!TextUtils.isEmpty(image)) {
            }
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvLike;
        TextView mTvCommentText;
        TextView mTvTimeText;
        TextView mTvUsername;

        ViewHolder(View view) {
            super(view);
        }
    }
}

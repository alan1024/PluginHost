package com.alan.pluginhost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.news.comments.Comment;

import java.util.List;

public class CommentsAdapter extends BaseAdapter {
    private Context mContext;
    private List<Comment> mCommentList;

    public CommentsAdapter(Context context, List<Comment> commentList) {
        mCommentList = commentList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCommentList.size();
    }

    @Override
    public Object getItem(int i) {
        return mCommentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_comments, null);
            viewHolder = new ViewHolder();
            viewHolder.mIvUserImage = (ImageView) view.findViewById(R.id.ivUserImage);
            viewHolder.mTvUserName = (TextView) view.findViewById(R.id.tvUserTitle);
            viewHolder.mTvDigNum = (TextView) view.findViewById(R.id.tvDigNum);
            viewHolder.mTvCommentText = (TextView) view.findViewById(R.id.tvCommentText);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Comment comment = mCommentList.get(i);
        getImage(viewHolder.mIvUserImage, comment.getUser_profile_image_url());
        viewHolder.mTvUserName.setText(comment.getUser_name());
        viewHolder.mTvDigNum.setText(comment.getDigg_count() + "");
        viewHolder.mTvCommentText.setText(comment.getText());
        return view;
    }

    public void getImage(ImageView imageView, String url) {
    }

    public static class ViewHolder {
        private ImageView mIvUserImage;
        private TextView mTvUserName;
        private TextView mTvDigNum;
        private TextView mTvCommentText;
    }
}

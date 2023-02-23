package com.alan.pluginhost.modules.video.videohome;

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
import com.alan.pluginhost.modules.video.videohome.mvp.RetDataBean;


public class VideoTypesAdapter extends BaseRecyclerAdapter {

    private Context mContext;
    private int image_width;
    private int image_height;

    public VideoTypesAdapter(Fragment fragment) {
        mContext = fragment.getContext();
        float value = fragment.getResources().getDimension(R.dimen.fixed_icon_grid);
        image_height = (int) value;
        image_width = (int) value * 4 / 3;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, BaseItem data) {
        ViewHolder holder = (ViewHolder) viewHolder;
        RetDataBean.ListBean listBean = (RetDataBean.ListBean) data.getData();
        String pic = listBean.getChildList().get(0).getPic();
        if (!TextUtils.isEmpty(pic)) {

        }
        holder.mTvVideoType.setText(listBean.getTitle());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvVideoType;
        TextView mTvVideoType;

        ViewHolder(View view) {
            super(view);
        }
    }
}

package com.alan.pluginhost.modules.video.videodetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;
import com.alan.pluginhost.modules.video.videodetail.mvp.MovieInfo;


public class VideoInfoAdapter extends BaseRecyclerAdapter {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    private int image_width;
    private int image_height;

    public VideoInfoAdapter(Fragment fragment) {
        mContext = fragment.getContext();
        float value = fragment.getResources().getDimension(R.dimen.fixed_icon_grid);
        image_width = (int) value;
        image_height = (int) value * 3 / 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, BaseItem data) {
        ViewHolder holder = (ViewHolder) viewHolder;
        MovieInfo.ListBean.ChildListBean listBean = (MovieInfo.ListBean.ChildListBean) data.getData();
        ViewGroup.LayoutParams params = holder.mCardVideoIt.getLayoutParams();
        params.height = image_height;
        holder.mCardVideoIt.setLayoutParams(params);
        String pic = listBean.getPic();
        if (!TextUtils.isEmpty(pic)) {

        }
        holder.mTvVideoType.setText(listBean.getTitle());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvVideoType;
        TextView mTvVideoType;
        CardView mCardVideoIt;

        ViewHolder(View view) {
            super(view);
            //获取到的是 SP 转换成 PX 后的值因此设置大小时要指定单位为 PX
            mTvVideoType.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension(R.dimen.fixed_icon_grid));
        }
    }
}

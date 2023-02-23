package com.alan.pluginhost.modules.zhihu.home;

import android.content.Context;
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
import com.alan.pluginhost.modules.zhihu.home.mvp.ZhiHuStory;

import java.util.Calendar;


public class ZhihuDailyAdapter extends BaseRecyclerAdapter {

    private Context mContext;
    private int image_width;
    private int image_height;

    public ZhihuDailyAdapter(Fragment fragment) {
        mContext = fragment.getContext();
        float width = fragment.getResources().getDimension(R.dimen.fixed_icon_grid);
        image_width = (int) width;
        image_height = image_width * 3 / 4;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view;
        if (viewType == RecyclerItemType.TYPE_TAGS.getiNum()) {
            view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
            return new TitleHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, BaseItem data) {
        if (data.getItemType() == RecyclerItemType.TYPE_NORMAL) { //普通内容
            ZhiHuStory story = (ZhiHuStory) data.getData();
            ViewHolder holder = (ViewHolder) viewHolder;
            holder.mNewsTitle.setText(story.getTitle());
            String image = story.getImages().get(0);
        } else if (data.getItemType() == RecyclerItemType.TYPE_TAGS) { //日期标签
            String title = (String) data.getData();
            int year = Integer.parseInt(title.substring(0, 4));
            int mon = Integer.parseInt(title.substring(4, 6));
            int day = Integer.parseInt(title.substring(6, 8));
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, mon - 1, day);
            TitleHolder holder = (TitleHolder) viewHolder;
        }
    }

    class TitleHolder extends Holder {
        TextView mItemTitle;

        TitleHolder(View view) {
            super(view);
        }
    }

    class ViewHolder extends Holder {
        ImageView mNewsImage;
        TextView mNewsTitle;

        ViewHolder(View view) {
            super(view);
        }
    }
}
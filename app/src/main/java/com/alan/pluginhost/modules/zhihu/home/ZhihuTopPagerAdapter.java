package com.alan.pluginhost.modules.zhihu.home;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.alan.pluginhost.R;
import com.alan.pluginhost.modules.zhihu.home.mvp.ZhiHuTopStory;

import java.util.ArrayList;

public class ZhihuTopPagerAdapter extends PagerAdapter {

    private ArrayList<ZhiHuTopStory> mTopStories;
    private Context mContext;
    private Activity mActivity;

    public ZhihuTopPagerAdapter(Fragment fragment, ArrayList<ZhiHuTopStory> topStories) {
        this.mTopStories = topStories;
        mActivity = fragment.getActivity();
        mContext = fragment.getContext();
    }

    @Override
    public int getCount() {
        return mTopStories != null ? mTopStories.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_main, container, false);
        String image = mTopStories.get(position).getImage();
        if (!TextUtils.isEmpty(image)) {
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void resetData(ArrayList<ZhiHuTopStory> topStories) {
        mTopStories.clear();
        mTopStories.addAll(topStories);
        notifyDataSetChanged();
    }
}

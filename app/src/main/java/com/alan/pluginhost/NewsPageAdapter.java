package com.alan.pluginhost;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NewsPageAdapter extends FragmentPagerAdapter {
    private final String[] fChannelNames;
    private final String[] fChannelUrls;
    private final int[] fChannelIds;
    private BaseFragment[] mFragments;
    private View.OnClickListener mOnClickListener;

    public NewsPageAdapter(FragmentManager fm, String[] channelNames, String[] channelUrls, int[] ids, View.OnClickListener onClickListener) {
        super(fm);
        fChannelNames = channelNames;
        fChannelUrls = channelUrls;
        fChannelIds = ids;
        mFragments = new BaseFragment[fChannelNames.length];
        mOnClickListener = onClickListener;
    }

    @Override
    public BaseFragment getItem(int position) {
        BaseFragment fragment = mFragments[position];
        if (fragment == null) {
            fragment = BaseFragment.newInstance(position, fChannelUrls[position], fChannelIds[position], mOnClickListener);
            mFragments[position] = fragment;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fChannelNames[position];
    }

    @Override
    public int getCount() {
        return fChannelNames.length;
    }

    public void destory() {
        if (mFragments != null) {
            int size = mFragments.length;
            for (int i = 0; i < size; i++) {
                if (mFragments[i] != null) {
                    mFragments[i].onDestroy();
                    mFragments[i] = null;
                }
            }
//			mFragments = null;
        }
        mOnClickListener = null;
    }
}
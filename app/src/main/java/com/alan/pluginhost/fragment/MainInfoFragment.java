package com.alan.pluginhost.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;

import com.alan.pluginhost.FixedPagerAdapter;
import com.alan.pluginhost.common.DefineView;
import com.alan.pluginhost.fragment.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;


public class MainInfoFragment extends BaseFragment implements DefineView, ViewPager.OnPageChangeListener {
    private View mView;
    private TabLayout tab_layout;
    private ViewPager info_viewpager;
    private FixedPagerAdapter fixedPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            initView();
            initValidata();
            initListener();
            bindData();
        }
        return mView;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initValidata() {
        fixedPagerAdapter = new FixedPagerAdapter(getChildFragmentManager());
        info_viewpager.setAdapter(fixedPagerAdapter);
        tab_layout.setupWithViewPager(info_viewpager);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void initListener() {
        info_viewpager.setOnPageChangeListener(this);
    }

    @Override
    public void bindData() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
        } else {
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

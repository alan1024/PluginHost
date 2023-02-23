package com.alan.pluginhost.modules.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alan.pluginhost.BaseFragment;
import com.alan.pluginhost.R;
import com.alan.pluginhost.modules.news.headline.HeadLineFragment;
import com.alan.pluginhost.modules.news.health.HealthFragment;
import com.alan.pluginhost.modules.news.military.MilitaryFragment;
import com.alan.pluginhost.modules.news.relaxing.RelaxFragment;
import com.alan.pluginhost.modules.news.sports.SportNewsFragment;
import com.alan.pluginhost.modules.news.technology.TecNewsFragment;
import com.alan.pluginhost.modules.news.travel.TravelFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class NewsMainFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    private ArrayList<Fragment> mFragmentArrayList;
    ViewPager mVpNewsList;
    TabLayout mTlNewsTabs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        initView();
        return view;
    }

    private void initView() {
        mFragmentArrayList = new ArrayList<>();
        mFragmentArrayList.add(new HeadLineFragment());
        mFragmentArrayList.add(new TecNewsFragment());
        mFragmentArrayList.add(new SportNewsFragment());
        mFragmentArrayList.add(new HealthFragment());
        mFragmentArrayList.add(new RelaxFragment());
        mFragmentArrayList.add(new MilitaryFragment());
        mFragmentArrayList.add(new TravelFragment());
        mVpNewsList.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentArrayList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentArrayList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "";
            }
        });
        mVpNewsList.addOnPageChangeListener(this);
        mTlNewsTabs.setupWithViewPager(mVpNewsList);
        mTlNewsTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mVpNewsList.setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

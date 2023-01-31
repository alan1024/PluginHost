package com.alan.pluginhost.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alan.pluginhost.R;
import com.alan.pluginhost.view.fragment.NewsFragment;
import com.alan.pluginhost.view.fragment.PicturesFragment;
import com.alan.pluginhost.view.fragment.WeatherFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewsFragment.newInstance();
            case 1:
                return PicturesFragment.newInstance();
            case 2:
                return WeatherFragment.newInstance();
            default:
                return NewsFragment.newInstance();
        }
//        return MainActivity.PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.main_tab_news);
            case 1:
                return context.getResources().getString(R.string.main_tab_picture);
            case 2:
                return context.getResources().getString(R.string.main_tab_weather);
        }
        return null;
    }
}

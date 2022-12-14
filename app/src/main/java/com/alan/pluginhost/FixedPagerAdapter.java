package com.alan.pluginhost;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.alan.pluginhost.entity.CategoriesBean;

import java.util.List;


public class FixedPagerAdapter extends FragmentStatePagerAdapter {
    private List<CategoriesBean> categoriesBeans;

    public void setCategoriesBeans(List<CategoriesBean> categoriesBeans) {
        this.categoriesBeans = categoriesBeans;
    }

    private List<Fragment> fragments;

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public FixedPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) super.instantiateItem(container, position);
        } catch (Exception e) {

        }
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categoriesBeans.get(position % categoriesBeans.size()).getTitle();
    }
}

package com.alan.pluginhost.basefragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alan.pluginhost.CategoryFragment;
import com.alan.pluginhost.FoundFragment;
import com.alan.pluginhost.MainActivity;
import com.alan.pluginhost.MainNewsFragment;
import com.alan.pluginhost.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ViewPager mViewPager;

    //fragment的集合
    private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();
    //fragment的标签集合
    private ArrayList<String> mLableList = new ArrayList<String>();

    private static Context mContext;
    private static FragmentManager mManager;

    private MainActivity mActivity;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;

    public static HomeFragment newInstance(Context context, FragmentManager manager) {
        HomeFragment homeFragment = new HomeFragment();
        mContext = context;
        mManager = manager;
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefrag_layout, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.content_pager);

        mActivity = (MainActivity) mContext;
        initPager();
        initFragment();
        return view;
    }

    //初始化Tablayou,viewpager，等
    private void initPager() {

        mFragmentList.add(MainNewsFragment.newInstance(mContext));
        mFragmentList.add(CategoryFragment.newInstance(mContext));
        mFragmentList.add(FoundFragment.newInstance(mContext));

        mLableList.add("主页");
        mLableList.add("分类");
        mLableList.add("发现");

    }

    public void initFragment() {
        ContentPagerAdp pagerAdp = new ContentPagerAdp(mManager);

        //设置Tablayout的模式
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //添加Tab
        for (int i = 0; i < mFragmentList.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mLableList.get(i)));
        }

        mViewPager.setAdapter(pagerAdp);
        mTabLayout.setupWithViewPager(mViewPager);

        //切换Tab时的监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mToolbar.setTitle(mLableList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //主fragment适配器
    class ContentPagerAdp extends FragmentPagerAdapter {

        public ContentPagerAdp(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        //刷新fragment，我博客中记录了
        @Override
        public long getItemId(int position) {
            int hashCode = mFragmentList.get(position).hashCode();
            return hashCode;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mLableList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }
}

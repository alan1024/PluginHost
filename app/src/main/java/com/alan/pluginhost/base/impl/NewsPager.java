package com.alan.pluginhost.base.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;

import com.alan.pluginhost.MainActivity;
import com.alan.pluginhost.base.BaseMenuDetailPager;
import com.alan.pluginhost.base.BasePager;
import com.alan.pluginhost.base.menudetail.InteractMenuDetailPager;
import com.alan.pluginhost.base.menudetail.NewsMenuDetailPager;
import com.alan.pluginhost.base.menudetail.PhotoMenuDetailPager;
import com.alan.pluginhost.base.menudetail.TopicMenuDetailPager;
import com.alan.pluginhost.bean.NewsData;
import com.alan.pluginhost.global.GlobalContants;
import com.alan.pluginhost.utils.CacheUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class NewsPager extends BasePager {

    private List<BaseMenuDetailPager> mMenuPagerList;
    private NewsData newsData;//网络解析的新闻数据

    public NewsPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        setSlidingMenuEnable(true);//侧边栏可以打开

        String cache = CacheUtils.getCache(mActivity, GlobalContants.CATEGORIES_URL);
        //若缓存不为空,则直接从缓存中获取json数据
        if (!TextUtils.isEmpty(cache)) {
            parseData(cache);
        }

        getDataFromServer();//无论是否有缓存,都要后台刷新新数据

    }

    /**
     * 从服务器获取数据
     */
    private void getDataFromServer() {
        //使用xUtils3实现与服务器的交互

    }

    /**
     * 解析网络数据
     *
     * @param result
     */
    private void parseData(String result) {
        Gson gson = new Gson();

        newsData = gson.fromJson(result, NewsData.class);
        System.out.println("解析结果：" + newsData);

        //刷新侧边栏数据
        MainActivity mainUI = (MainActivity) mActivity;

        //准备4个菜单栏详情页面
        mMenuPagerList = new ArrayList<>();
        mMenuPagerList.add(new NewsMenuDetailPager(mActivity, newsData.data.get(0).children));
        mMenuPagerList.add(new TopicMenuDetailPager(mActivity));
        mMenuPagerList.add(new PhotoMenuDetailPager(mActivity, imBtnPhotoType));
        mMenuPagerList.add(new InteractMenuDetailPager(mActivity));

        //第一次进入新闻界面为菜单详情第一页
        setCurrentMenuDetailPager(0);

    }

    /**
     * 设置当前菜单栏详情页
     */
    public void setCurrentMenuDetailPager(int position) {
        BaseMenuDetailPager pager = mMenuPagerList.get(position);
        mFlContent.removeAllViews();//移除之前添加的View
        mFlContent.addView(pager.mRootView);

        //设置标题栏与侧边栏菜单详情标题匹配
        mTvTitle.setText(newsData.data.get(position).title);


        //这里调用initData方法
        pager.initData();

        //只有在组图界面才显示切换按钮
        if (pager instanceof PhotoMenuDetailPager) {
            imBtnPhotoType.setVisibility(View.VISIBLE);
        } else {
            imBtnPhotoType.setVisibility(View.GONE);
        }
    }
}

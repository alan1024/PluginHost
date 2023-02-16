package com.alan.pluginhost.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.alan.pluginhost.base.BasePager;

public class SmartPager extends BasePager {


    public SmartPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        mTvTitle.setText("生活");
        setSlidingMenuEnable(true);

        TextView text = new TextView(mActivity);
        text.setText("智慧服务");
        text.setTextSize(25);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);

        //添加到Content中
        mFlContent.addView(text);

    }
}

package com.alan.pluginhost.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.alan.pluginhost.base.BasePager;

public class GovPager extends BasePager {


    public GovPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        mTvTitle.setText("人口管理");
        setSlidingMenuEnable(true);

        TextView text = new TextView(mActivity);
        text.setText("政务");
        text.setTextSize(25);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);

        //添加到Content中
        mFlContent.addView(text);

    }
}

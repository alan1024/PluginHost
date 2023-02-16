package com.alan.pluginhost.base.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.alan.pluginhost.base.BaseMenuDetailPager;

public class InteractMenuDetailPager extends BaseMenuDetailPager {


    public InteractMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {

        TextView text = new TextView(mActivity);
        text.setText("菜单详情页-互动");
        text.setTextSize(25);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);

        return text;
    }
}

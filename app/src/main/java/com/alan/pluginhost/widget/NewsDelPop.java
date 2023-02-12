package com.alan.pluginhost.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsDelPop {
    private static final String TAG = "NewsDelPop";
    List<String> backreason;
    List<Integer> selectid;
    ImageView ivTop;
    RecyclerView recyclerView;
    TextView tvNolike;
    ImageView ivDown;

    private int position;

    private onClickListener onClickListener;

    public interface onClickListener {
        void onClick(int position);
    }

    public void setClickListener(onClickListener clickListener) {
        onClickListener = clickListener;
    }


    public NewsDelPop setBackReason(List<String> backreason, boolean isTop, int position) {
        this.backreason = backreason;
        this.position = position;
        selectid = new ArrayList<>();
        selectid.clear();
        if (isTop) {
            ivTop.setVisibility(View.GONE);
            ivDown.setVisibility(View.VISIBLE);
        } else {
            ivTop.setVisibility(View.VISIBLE);
            ivDown.setVisibility(View.GONE);
        }
        return this;
    }

}

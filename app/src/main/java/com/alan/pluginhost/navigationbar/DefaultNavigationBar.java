package com.alan.pluginhost.navigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder> {
    DefaultNavigationBar(Builder builder) {
        super(builder);
    }

    @Override
    public void attachNavigationParams() {
        super.attachNavigationParams();
        // 处理特有的
        TextView leftView = findViewById(1);
        leftView.setVisibility(getBuilder().mLeftVisible);

    }

    public static class Builder extends AbsNavigationBar.Builder<Builder> {
        public int mLeftVisible = View.VISIBLE;

        public Builder(Context context, ViewGroup parent) {
            super(context, 1, parent);
        }

        @Override
        public DefaultNavigationBar create() {
            return new DefaultNavigationBar(this);
        }

        public Builder setLeftText(String text) {
            setText(1, text);
            return this;
        }

        public Builder setLeftClickListener(View.OnClickListener clickListener) {
            setOnClickListener(1, clickListener);
            return this;
        }

        public Builder hideLeftText() {
            mLeftVisible = View.GONE;
            return this;
        }
    }
}

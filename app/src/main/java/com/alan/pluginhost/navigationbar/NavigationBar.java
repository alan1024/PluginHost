package com.alan.pluginhost.navigationbar;

import android.content.Context;
import android.view.ViewGroup;

public class NavigationBar extends AbsNavigationBar {
    NavigationBar(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbsNavigationBar.Builder<Builder> {

        public Builder(Context context, int layoutId, ViewGroup parent) {
            super(context, layoutId, parent);
        }

        @Override
        public NavigationBar create() {
            return new NavigationBar(this);
        }
    }
}

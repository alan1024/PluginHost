package com.alan.pluginhost.navigationbar;

import android.view.View;
import android.view.ViewGroup;

public interface INavigation {
    /**
     * 创建View
     */
    void createNavigationBar();

    /**
     * 添加参数
     */
    void attachNavigationParams();

    void attachParent(View navigationBarView, ViewGroup parent);
}

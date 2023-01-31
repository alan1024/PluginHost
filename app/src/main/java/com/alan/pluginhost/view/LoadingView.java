package com.alan.pluginhost.view;

import android.view.View;

public interface LoadingView {
    void showLoading();

    void showContent();

    void showError(int messageId, View.OnClickListener listener);
}

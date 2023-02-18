package com.alan.pluginhost.ui.contract;

import android.webkit.WebView;
import android.widget.ProgressBar;

import com.alan.pluginhost.base.BaseContract;

public class GankWebContract {
    public interface View extends BaseContract.BaseView {
        ProgressBar getProgressBar();

        WebView getWebView();
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void setWebView(String url);
    }
}

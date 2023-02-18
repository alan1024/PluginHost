package com.alan.pluginhost.ui.contract;

import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alan.pluginhost.base.BaseContract;

public class ZhiHuWebContract {
    public interface View extends BaseContract.BaseView {
        WebView getWebView();

        ImageView getWebImg();

        TextView getImgTitle();

        TextView getImgSource();
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getDetailNews(String id);
    }
}

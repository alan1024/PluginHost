package com.alan.pluginhost.delegate;

import android.graphics.Bitmap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import com.alan.pluginhost.R;
import com.alan.pluginhost.mvp_frame.view.AppDelegate;
import com.alan.pluginhost.utils.GlideUtil;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;

public class NewsDetailActivityDelegate extends AppDelegate {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.iv_detail)
    ImageView mImageView;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        initWebView();
    }

    /**
     * 初始化webview
     */
    private void initWebView() {
        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //设置 缓存模式(true);
        ws.setAppCacheEnabled(true);
        ws.setSupportZoom(false);
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setJavaScriptCanOpenWindowsAutomatically(true);//js支持
        ws.setDomStorageEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });
    }

    @Override
    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setCollapsingToolbarLayoutTitle(String title) {
        mCollapsingToolbarLayout.setTitle(title);
    }

    public void setImageWithURL(String url) {
        GlideUtil.loadImage(getActivity(), url, mImageView);
    }

    public void loadNewsDetail(String url) {
        mWebView.loadUrl(url);
    }
}

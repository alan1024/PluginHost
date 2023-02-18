package com.alan.pluginhost.ui.presenter;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alan.pluginhost.R;
import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.bean.zhihu.News;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.ZhiHuWebContract;

import javax.inject.Inject;

public class ZhihuWebViewPresenter extends BasePresenter<ZhiHuWebContract.View> implements ZhiHuWebContract.Presenter {
    private Context mContext;

    @Inject
    public ZhihuWebViewPresenter(@ContextLife Context context) {
        mContext = context;
    }

    @Override
    public void getDetailNews(String id) {
//        RetrofitManager.createZhiHuIo(ZhihuApi.class).getDetailNews(id)
//                .compose(mView.bindToLife())
//                .compose(RxSchedulers.applySchedulers())
//                .subscribe(news -> {
//                    setWebView(news);
//                }, this::loadError);
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(mContext, R.string.common_signin_button_text, Toast.LENGTH_SHORT).show();
    }

    ImageView webImg;

    public void setWebView(News news) {
        WebView webView = mView.getWebView();
        webImg = mView.getWebImg();
        TextView imgTitle = mView.getImgTitle();
        TextView imgSource = mView.getImgSource();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);// 支持JS
        settings.setBuiltInZoomControls(true);// 显示放大缩小按钮
        settings.setUseWideViewPort(true);// 支持双击放大缩小
        String head = "<head>\n" +
                "\t<link rel=\"stylesheet\" href=\"" + news.getCss()[0] + "\"/>\n" +
                "</head>";
        String img = "<div class=\"headline\">";
        String html = head + news.getBody().replace(img, " ");
        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        imgTitle.setText(news.getTitle());
        imgSource.setText(news.getImage_source());
    }
}

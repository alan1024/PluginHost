package com.alan.pluginhost.utils.wanpwd;

import androidx.annotation.Nullable;

import com.alan.pluginhost.utils.router.Router;

import java.net.URLDecoder;

/**
 * @author CuiZhen
 * @date 2019/12/28
 * GitHub: https://github.com/goweii
 */
public class WebWanPwd implements IWanPwd {

    private final String content;
    private String mShowText;
    private String mBtnText;
    private Runnable mRunnable;

    public WebWanPwd(String content) {
        this.content = content;
        parse();
    }

    @Nullable
    @Override
    public Runnable getRunnable() {
        return mRunnable;
    }

    @Override
    public String getShowText() {
        return mShowText;
    }

    @Override
    public String getBtnText() {
        return mBtnText;
    }

    private void parse() {
        mShowText = "你发现了一个网页链接！\n要不要去打开看一下？";
        mBtnText = "打开";
        final String url = URLDecoder.decode(content);
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Router.routeTo(url);
            }
        };
    }
}

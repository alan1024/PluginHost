package com.alan.pluginhost.utils.wanpwd;

import androidx.annotation.Nullable;


/**
 * @author CuiZhen
 * @date 2020/1/1
 * GitHub: https://github.com/goweii
 */
public class CreateCDKeyWanPwd implements IWanPwd {

    private final Runnable mRunnable;

    public CreateCDKeyWanPwd(String content) {
        mRunnable = new Runnable() {
            @SuppressWarnings("StringBufferReplaceableByString")
            @Override
            public void run() {

            }
        };
    }

    @Nullable
    @Override
    public Runnable getRunnable() {
        return mRunnable;
    }

    @Override
    public String getShowText() {
        return "###激活码生成###\n\n！！！警告！！！\n\n该功能仅限开发者使用";
    }

    @Override
    public String getBtnText() {
        return "复制";
    }
}

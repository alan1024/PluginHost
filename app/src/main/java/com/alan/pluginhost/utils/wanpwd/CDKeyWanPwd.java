package com.alan.pluginhost.utils.wanpwd;

import androidx.annotation.Nullable;


/**
 * @author CuiZhen
 * @date 2020/1/1
 * GitHub: https://github.com/goweii
 */
public class CDKeyWanPwd implements IWanPwd {

    private final Runnable mRunnable;

    public CDKeyWanPwd(String content) {
        mRunnable = new Runnable() {
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
        return "你发现了一个激活码！\n激活码仅与当前登录账户绑定，更换设备或账户后需重新激活，成功激活后将会去除所有广告，是否立即激活？";
    }

    @Override
    public String getBtnText() {
        return "激活";
    }
}

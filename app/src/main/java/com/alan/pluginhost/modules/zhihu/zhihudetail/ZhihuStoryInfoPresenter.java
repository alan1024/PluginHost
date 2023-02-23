package com.alan.pluginhost.modules.zhihu.zhihudetail;

import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;


/**
 * Created by PandaQ on 2016/10/10.
 * email : 767807368@qq.com
 */

class ZhihuStoryInfoPresenter extends BasePresenter implements ZhiHuDetailContract.Presenter {

    private ZhiHuDetailContract.View mActivity;

    @Override
    public void loadStory(String id) {


    }

    @Override
    public void bindView(ImpBaseView view) {
        mActivity = (ZhiHuDetailContract.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mActivity = null;
    }
}

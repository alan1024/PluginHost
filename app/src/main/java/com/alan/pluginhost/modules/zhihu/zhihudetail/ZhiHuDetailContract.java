package com.alan.pluginhost.modules.zhihu.zhihudetail;

import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

interface ZhiHuDetailContract {
    interface View extends ImpBaseView {

        void loadZhihuStory();

        void loadFail(String errmsg);

        void loadSuccess(ZhihuStoryContent zhihuStory);
    }

    interface Presenter extends ImpBasePresenter {
        void loadStory(String id);
    }
}

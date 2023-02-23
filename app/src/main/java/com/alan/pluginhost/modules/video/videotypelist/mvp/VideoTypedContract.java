package com.alan.pluginhost.modules.video.videotypelist.mvp;

import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;


interface VideoTypedContract {
    interface View extends ImpBaseView {
        void loadMore();

        void noMoreVideo();

        void loadMoreSuccess(ArrayList<BaseItem> list);

        void loadFail(String errCode, String errMsg);
    }

    interface Presenter extends ImpBasePresenter {
        void loadVideos(String id);

        void loadLives(String id);

        void loadData(String title);
    }
}

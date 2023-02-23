package com.alan.pluginhost.modules.video.videodetail.mvp;


import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.modules.ImpBasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.util.ArrayList;

public interface VideoCommentContract {
    interface View extends ImpBaseView {
        void loadComment();

        void refreshComment();

        String getDataId();

        void showComment(ArrayList<BaseItem> listBeen);

        void noMore();

        void loadFail();
    }

    interface Presenter extends ImpBasePresenter {
        void refreshComment();

        void loadMoreComment();
    }
}

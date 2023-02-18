package com.alan.pluginhost.ui.contract;

import com.alan.pluginhost.base.BaseContract;
import com.alan.pluginhost.bean.video.MediaItem;

import java.util.List;

public class MusicContract {
    public interface View extends BaseContract.BaseView {
        void displayMusic(List<MediaItem> mediaItems);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getMusicDataFromLocal();
    }
}

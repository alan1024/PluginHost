package com.alan.pluginhost.ui.contract;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.base.BaseContract;

public class DailyFeedContract {
    public interface View extends BaseContract.BaseView {

        void setDataRefresh(Boolean refresh);

        RecyclerView getRecyclerView();

        GridLayoutManager getLayoutManager();
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getDailyFeedDetail(String id, String num);
    }
}

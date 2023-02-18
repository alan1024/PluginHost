package com.alan.pluginhost.ui.contract;

import com.alan.pluginhost.base.BaseContract;
import com.alan.pluginhost.bean.gank.Gank;

import java.util.List;

public class GankContract {

    public interface View extends BaseContract.BaseView {
        void displayMeizhi(List<Gank> meiZhiList);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getGankData(int pageNum);
    }
}

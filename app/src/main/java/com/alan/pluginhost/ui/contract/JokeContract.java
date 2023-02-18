package com.alan.pluginhost.ui.contract;

import com.alan.pluginhost.base.BaseContract;
import com.alan.pluginhost.bean.jandan.JokeBean;

public class JokeContract {
    public interface View extends BaseContract.BaseView {
        void displayJokeList(JokeBean jokeBean);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        public void getDetailData(int page);
    }
}

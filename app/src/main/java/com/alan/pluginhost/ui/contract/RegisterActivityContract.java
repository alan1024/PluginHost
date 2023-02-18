package com.alan.pluginhost.ui.contract;


import com.alan.pluginhost.base.BaseContract;

public interface RegisterActivityContract {
    public interface View extends BaseContract.BaseView {
        /**
         * 注册成功后业务逻辑
         */
        void showRegisterSuccess();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        /**
         * 注册接口
         */
        void register(String account, String password, String rePassword);
    }
}

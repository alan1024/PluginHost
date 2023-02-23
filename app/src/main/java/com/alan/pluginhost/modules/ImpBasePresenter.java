package com.alan.pluginhost.modules;


public interface ImpBasePresenter {
    void bindView(ImpBaseView view);

    void unbindView();

    void onDestory();
}

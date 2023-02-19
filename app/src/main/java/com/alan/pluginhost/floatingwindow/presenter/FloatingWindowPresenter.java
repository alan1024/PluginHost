package com.alan.pluginhost.floatingwindow.presenter;

public interface FloatingWindowPresenter {
    void loadNewsInFloatingWindow(int type, int page);

    void loadNewsDetailInFloatingWindow(String docid);
}

package com.alan.pluginhost.guide.view;


public interface GuideView {
    void showProgressbar();

    void hideProgressbar();

    void registerNewUser();

    void onSuccessFound();

    void onFailureFound(String message);
}

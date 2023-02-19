package com.alan.pluginhost.main.presenter;

import com.alan.pluginhost.main.view.MainView;


public class MainPresenterImpl implements MainPresenter {
    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
//            case R.id.navigation_item_news:
//                mMainView.switch2News();
//                break;
//            case R.id.navigation_item_images:
//                mMainView.switch2Images();
//                break;
//            case R.id.navigation_item_about:
//                mMainView.switch2About();
//                break;
//            case R.id.navigation_item_floating:
//                mMainView.switch2FloatingWindow();
//                break;
            default:
                mMainView.switch2News();
                break;
        }
    }
}

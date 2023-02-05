package com.alan.pluginhost.rx;


import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import rx.Observable;

public class RxNetworking {

    public static <T> Observable.Transformer<T, T> bindRefreshing(SwipeRefreshLayout indicator) {
        return observable -> observable
                .doOnSubscribe(() -> indicator.post(() -> indicator.setRefreshing(true)))
                .doOnError(e -> indicator.post(() -> indicator.setRefreshing(false)))
                .doOnCompleted(() -> indicator.post(() -> indicator.setRefreshing(false)));
    }


}

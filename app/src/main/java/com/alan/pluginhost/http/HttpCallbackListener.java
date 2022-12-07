package com.alan.pluginhost.http;

public interface HttpCallbackListener {
    void onSuccess(String result);

    void onError(Exception e);
}

package com.alan.pluginhost.http;


public interface ProgressResponseListener {
    public void onResponseProgress(long bytesRead, long contentLength, boolean done);
}

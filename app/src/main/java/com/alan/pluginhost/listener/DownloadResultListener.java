package com.alan.pluginhost.listener;

public interface DownloadResultListener {

    /**
     * onStart
     */
    public void onStart();

    /**
     * onProgress
     *
     * @param progress
     */
    public void onProgress(int progress);

    /**
     * onEnd
     */
    public void onEnd();

}

package com.alan.pluginhost.images.model;

import com.alan.pluginhost.beans.ImageBean;
import com.alan.pluginhost.common.Urls;
import com.alan.pluginhost.images.ImageJsonUtils;
import com.alan.pluginhost.utils.LogUtils;
import com.alan.pluginhost.utils.OkHttpUtils;

import java.util.List;


public class ImageModelImpl implements ImageModel {
    private final String TAG = "ImageModelImpllll";

    @Override
    public void loadImageList(final OnLoadImageListListener listener) {
        String url = Urls.IMAGES_URL + addParams();
        LogUtils.d(TAG, "url is " + url);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                LogUtils.d(TAG, "response is " + response);
                List<ImageBean> beans = ImageJsonUtils.readJsonImageBeans(response);
                listener.onSuccess(beans);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("loadImageList error", e);
            }
        };

        OkHttpUtils.get(url, loadNewsCallback);
    }

    private String addParams() {
        return "?";
    }

    public interface OnLoadImageListListener {
        void onSuccess(List<ImageBean> list);

        void onFailure(String msg, Exception e);
    }
}

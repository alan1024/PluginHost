package com.alan.pluginhost.images.presenter;

import com.alan.pluginhost.beans.ImageBean;
import com.alan.pluginhost.images.model.ImageModel;
import com.alan.pluginhost.images.model.ImageModelImpl;
import com.alan.pluginhost.images.view.ImageView;

import java.util.List;


public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

    private ImageModel mImageModel;
    private ImageView mImageView;

    public ImagePresenterImpl(ImageView imageView) {
        mImageView = imageView;
        mImageModel = new ImageModelImpl();
    }

    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mImageModel.loadImageList(this);
    }

    @Override
    public void onSuccess(List<ImageBean> list) {
        mImageView.addImages(list);
        mImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mImageView.hideProgress();
        mImageView.showLoadFailMsg();
    }
}

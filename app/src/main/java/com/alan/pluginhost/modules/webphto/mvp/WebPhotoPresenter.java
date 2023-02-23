package com.alan.pluginhost.modules.webphto.mvp;

import android.content.Context;
import android.os.Environment;

import com.alan.pluginhost.modules.BasePresenter;
import com.alan.pluginhost.modules.ImpBaseView;

import java.io.File;


class WebPhotoPresenter extends BasePresenter implements WebPhotoContact.Presenter {
    private WebPhotoContact.View mView;
    private Context mContext;

    WebPhotoPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void savePic(final String url) {

    }

    private File getDCIMFile(String imageName) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) { // 文件可用
            File dirs = new File(Environment.getExternalStorageDirectory(),
                    "DCIM" + "/PandaEye/");
            if (!dirs.exists()) {
                dirs.mkdirs();
            }
            File file = new File(Environment.getExternalStorageDirectory(),
                    "DCIM" + "/PandaEye/" + imageName);
            if (!file.exists()) { //如果文件存在（已经下载过则直接返回空）
                try {
                    //在指定的文件夹中创建文件
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return file;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void bindView(ImpBaseView view) {
        mView = (WebPhotoContact.View) view;
    }

    @Override
    public void unbindView() {
        dispose();
    }

    @Override
    public void onDestory() {
        mView = null;
        mContext = null;
    }
}

package com.alan.pluginhost.ui.presenter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.bean.video.MediaItem;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.MusicContract;
import com.alan.pluginhost.utils.UIUtils;

import java.util.ArrayList;

import javax.inject.Inject;


public class MusicPresenter extends BasePresenter<MusicContract.View> implements MusicContract.Presenter {
    private final Context mContext;


    @Inject
    public MusicPresenter(@ContextLife Context context) {
        this.mContext = context;
    }

    @Override
    public void getMusicDataFromLocal() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                ArrayList<MediaItem> mediaItems = new ArrayList<>();
                ContentResolver resolver = mContext.getContentResolver();
                //获取uri
                Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Audio.Media.DISPLAY_NAME,//音频的名字
                        MediaStore.Audio.Media.DURATION,//音频的时长
                        MediaStore.Audio.Media.SIZE,//音频的大小
                        MediaStore.Audio.Media.DATA,//音频的绝对地址
                        MediaStore.Audio.Media.ARTIST,//歌曲的演唱者
                };
                Cursor cursor = resolver.query(uri, objs, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        MediaItem mediaItem = new MediaItem();
                        mediaItems.add(mediaItem);

                        String name = cursor.getString(0);//音频的名字
                        mediaItem.setName(name);
                        long duration = cursor.getLong(1);//音频的时长
                        mediaItem.setDuration(duration);

                        long size = cursor.getLong(2);//音频的文件大小
                        mediaItem.setSize(size);

                        String data = cursor.getString(3);//音频的播放地址
                        mediaItem.setData(data);

                        String artist = cursor.getString(4);//艺术家
                        mediaItem.setArtist(artist);

                    }
                    cursor.close();
                }
                UIUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.displayMusic(mediaItems);
                    }
                });
            }

        }.start();


    }
}

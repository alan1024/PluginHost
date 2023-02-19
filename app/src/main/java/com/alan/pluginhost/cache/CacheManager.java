package com.alan.pluginhost.cache;

import android.graphics.Bitmap;
import android.widget.ImageView;


public class CacheManager {
    private LocalCacheUtils mLocalCacheUtils;
    private MemoryCacheUtils mMemoryCacheUtils;
    private NetworkCacheUtils mNetworkCacheUtils;

    public CacheManager() {
        mLocalCacheUtils = new LocalCacheUtils();
        mMemoryCacheUtils = new MemoryCacheUtils();
        mNetworkCacheUtils = new NetworkCacheUtils(mMemoryCacheUtils, mLocalCacheUtils);
    }

    public void display(ImageView imageView, String url) {
        Bitmap bitmap;
        bitmap = mMemoryCacheUtils.getBitmapFromFromMemory(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            mMemoryCacheUtils.saveBitmapToMemory(bitmap, url);//之所以不在LocalCacheUtils的类中实现向内存添加的原因是解耦，防止在本地缓存的时候一定要内存缓存
            return;
        }

        mNetworkCacheUtils.getBitmapFromNetwork(imageView, url);//内部在查找成功后会自动向memoryCache和LocalCache添加
    }
}

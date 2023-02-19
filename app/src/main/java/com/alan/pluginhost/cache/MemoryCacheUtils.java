package com.alan.pluginhost.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryCacheUtils {
    //立个flag：：LruCache的原理一定要看
    private LruCache<String, Bitmap> mMemoryCache;

    public MemoryCacheUtils() {
        long maxSize = Runtime.getRuntime().maxMemory() / 8;
        mMemoryCache = new LruCache<String, Bitmap>((int) maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    public Bitmap getBitmapFromFromMemory(String url) {
        return mMemoryCache.get(url);
    }

    public void saveBitmapToMemory(Bitmap bitmap, String url) {
        mMemoryCache.put(url, bitmap);
    }
}

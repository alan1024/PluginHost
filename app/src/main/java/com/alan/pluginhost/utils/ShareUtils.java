package com.alan.pluginhost.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.alan.pluginhost.utils.bitmap.BitmapUtils;

import java.io.File;

/**
 * @author CuiZhen
 * @date 2019/11/10
 * GitHub: https://github.com/goweii
 */
public class ShareUtils {

    public static void shareBitmap(Context context, Bitmap bitmap) {
        File file = BitmapUtils.saveBitmapToCache(bitmap);
        bitmap.recycle();
        if (file == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, UriUtils.getFileUri(file));
        intent = Intent.createChooser(intent, "分享到");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void shareLink(Context context, String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, url);
        intent.setType("text/plain");
        intent = Intent.createChooser(intent, "分享到");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}

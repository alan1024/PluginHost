package com.alan.pluginhost;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


public class ShowHeaderUtils {

    /*
    从数据库中加载头像
     */
    public static void showHeadImageFromDB(Context context, ImageView headerImage) {
        String imageUrl = SharedPrerensUtils.getString(context, "headerUrl");
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .crossFade()
                    .into(headerImage);
        }
    }

    /*
    从服务器加载头像
     */
    public static void showHeadImageFromServer(final Context context, final ImageView headerImage) {
        Log.d("showHeadImageFromServer", Config.login_name);
        //只有登录了才会加载
        if (SharedPrerensUtils.getBoolean(context, Config.ISLOGIN)) {
            OkHttpUtils.post()
                    .url(Config.LOCAL_URL)
                    .addParams(Config.ACTION, Config.ACTION_SEARCH_INFO)
                    .addParams(Config.USERNAME, Config.login_name)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Toast.makeText(context, "网络异常", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.d("showHeadImageFromServer", response);
                            String imageUrl = null;
                            if (response != null) {
                                Gson gson = new Gson();
                                InfoBean mInfoBean = gson.fromJson(response, InfoBean.class);
                                imageUrl = mInfoBean.headUrl;
                            }
                            if (imageUrl != null && imageUrl.length() > 5) {
                                Log.d("showHeadImageFromServer", imageUrl);
                                Glide.with(context)
                                        .load(imageUrl)
                                        .centerCrop()
                                        .crossFade()
                                        .into(headerImage);
                            }

                        }
                    });
        }
    }

}

package com.alan.pluginhost.http;

import com.alan.pluginhost.bean.ImageDetailBean;
import com.alan.pluginhost.bean.NewsDetailBean;
import com.alan.pluginhost.bean.NewsListNormalBean;
import com.alan.pluginhost.bean.PicListBean;
import com.alan.pluginhost.bean.VideoBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Bei on 2017/1/6.
 * 解析Json数据的工具类
 */

public class DataParse {

    // 新闻列表解析
    public static ArrayList<NewsListNormalBean> NewsList(String json, String id) {
        // Gson, JsonObject
        // 使用JsonObject解析方式: 如果遇到{},就是JsonObject;如果遇到[], 就是JsonArray
        if (json != null) {
            JSONObject jsonObject = null;
            ArrayList<NewsListNormalBean> newsListNormalBeans = new ArrayList<>();
            try {
                jsonObject = new JSONObject(json);
                JSONArray array = jsonObject.getJSONArray(id);

                return newsListNormalBeans;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
        }
        return null;
    }


    /**
     * 新闻详情页解析
     *
     * @param result
     * @param tid
     * @return
     */
    public static NewsDetailBean NewsDetail(String result, String tid) {
        if (result != null) {
            JSONObject jsonObject = null;
            NewsDetailBean newsDetailBean;
            try {
                jsonObject = new JSONObject(result);
                String detail = jsonObject.getJSONObject(tid).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
        }
        return null;
    }

    /**
     * 图片列表解析
     *
     * @param result
     * @return
     */
    public static ArrayList<PicListBean> PicList(String result) {

        return null;
    }

    /**
     * 图片新闻详情页解析
     *
     * @param result
     * @return
     */
    public static ImageDetailBean ImageDetail(String result) {
        ImageDetailBean imageDetailBean = null;

        return imageDetailBean;
    }

    /**
     * 视频列表解析
     *
     * @param result
     * @return
     */
    public static ArrayList<String> VideoList(String result) {

        return null;
    }

    /**
     * 视频详情页解析
     *
     * @param result
     * @return
     */
    public static VideoBean VideoDetail(String result) {
        VideoBean bean = null;
        return bean;
    }
}

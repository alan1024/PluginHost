package com.alan.pluginhost.basefragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.CacheUtils;
import com.alan.pluginhost.CollectsBean.Collects;
import com.alan.pluginhost.CollectsBean.CollectsList;
import com.alan.pluginhost.Config;
import com.alan.pluginhost.MainActivity;
import com.alan.pluginhost.R;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class CollectFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private static Context mContext;

    private List<CollectsList> mCollectList = new ArrayList<>();
    private MainActivity mActivity;
    private CollectAdapter adapter;

    private static final String CACHE_COLLECTS = "collects" + Config.login_name;//缓存收藏列表的键

    private boolean first = true;//第一次进入收藏和从收藏点击新闻回到收藏执行不同刷新

    public static CollectFragment newInstance(Context context) {
        CollectFragment roomFragment = new CollectFragment();
        mContext = context;
        return roomFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init("CollectFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.collect_layout, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.collect_recycler);
        mActivity = (MainActivity) getActivity();
        initTab();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        String cache = CacheUtils.getCache(mContext, CACHE_COLLECTS);
        if (!TextUtils.isEmpty(cache)) {
            parseData(cache);
        }
        getDataFromServer();
    }

    //设置Tab
    public void initTab() {
        TabLayout mTabLayout = new TabLayout(mActivity);
        mTabLayout.removeAllTabs();
        mTabLayout.addTab(mTabLayout.newTab().setText("我的收藏"));
    }

    private void getDataFromServer() {
        OkHttpUtils.post()
                .url(Config.LOCAL_URL)
                .addParams(Config.ACTION, Config.ACTION_GET_COLLECTS)
                .addParams("username", Config.login_name)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (response != null) {
                            Log.d("onResponse", response);
                            parseData(response);
                        }
                    }
                });
    }

    public void parseData(String result) {
        Gson gson = new Gson();
        int status = gson.fromJson(result, Collects.class).status;
        CacheUtils.setCache(mContext, CACHE_COLLECTS, result);//缓存收藏列表
        if (status == 1) {
            if (first) {
                mCollectList.addAll(gson.fromJson(result, Collects.class).collections);
                adapter = new CollectAdapter();
                LinearLayoutManager manager = new LinearLayoutManager(mContext);
                manager.setOrientation(RecyclerView.VERTICAL);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(adapter);
                first = false;
            } else {
                mCollectList.clear();
                mCollectList.addAll(gson.fromJson(result, Collects.class).collections);
                adapter.notifyDataSetChanged();
            }

        } else {
            Toast.makeText(mContext, "你暂未收藏任何新闻或文章", Toast.LENGTH_SHORT).show();
            if (adapter != null) {
                mCollectList.clear();
                adapter.notifyDataSetChanged();
            }
        }
    }

    public class CollectAdapter extends BaseQuickAdapter<CollectsList, BaseViewHolder> {

        public CollectAdapter() {
            super(R.layout.rv_item, mCollectList);
        }

        @Override
        protected void convert(BaseViewHolder helper, CollectsList collectsList) {
            helper.setText(R.id.cv_text, collectsList.title);
            helper.setText(R.id.date, collectsList.date);

            Glide.with(mContext)
                    .load(collectsList.thumbnail_pic_s)
                    .centerCrop()
                    .placeholder(R.drawable.defaultpic)
                    .crossFade()
                    .into((ImageView) helper.getView(R.id.cv_image));

            helper.setOnClickListener(R.id.cv_id, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

}

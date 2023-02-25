package com.alan.pluginhost;


import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


public class MainNewsFragment extends Fragment {

    //最好使用newinstance方式来获取fragment实例

    private static Context mContext;

    private RVAdapter adapter;

    //总的新闻条数
    private List<NewsBean.NewsDetailList> mHomeList = null;

    private List<NewsBean.NewsDetailList> mTopList = new ArrayList<>();
    private List<NewsBean.NewsDetailList> mItemList = new ArrayList<>();

    public static MainNewsFragment newInstance(Context context) {
        MainNewsFragment newsFragment = new MainNewsFragment();
        mContext = context;
        Logger.d("MainNewsFragment");
        return newsFragment;
    }

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private LinearLayoutManager mManager;

    private static final String MAIN_URL = Config.REQUEST_URL + Config.TOP + Config.KEY
            + Config.APP_KEY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("register");
        Logger.init("MainNewsFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_news_layout, container, false);
        //获得RecycleView
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycleView);
        mManager = new LinearLayoutManager(mContext);

        //获取RefreshLayout
        mRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefresh);

        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String cache = CacheUtils.getCache(mContext, MAIN_URL);

        if (!TextUtils.isEmpty(cache)) {
            parseData(cache);
        }
        getDataFromServer();
        //RefreshLayout的设置
        mRefreshLayout.setColorSchemeResources(R.color.colorYellow);
//        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getDataFromServer();
//            }
//        });

    }

    //是否传递参数
    private void getDataFromServer() {
        OkHttpUtils.get()
                .url(MAIN_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
                        mRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        CacheUtils.setCache(mContext, MAIN_URL, response);
                        if (!TextUtils.isEmpty(response)) {
                            parseData(response);
                        }
                    }
                });
    }

    public void parseData(String result) {
        mRefreshLayout.setRefreshing(false);
        if (result.equals(Config.FAIL)) {
            Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
        } else {
            Gson gson = new Gson();
            NewsBean newsBean = gson.fromJson(result, NewsBean.class);
            if (newsBean.result != null) {
                mHomeList = newsBean.result.data;
                mTopList = mHomeList.subList(0, 5);
                mItemList = mHomeList.subList(5, mHomeList.size());

                adapter = new RVAdapter(mContext, mHomeList, mTopList, mItemList);
                mManager.setOrientation(RecyclerView.VERTICAL);
                mRecyclerView.setLayoutManager(mManager);
                mRecyclerView.setAdapter(adapter);
            }
        }

        if (adapter != null) {
            adapter.setOnItemClickListener(new RVAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, NewsBean.NewsDetailList beanData) {

                }

            });
        }

    }

}

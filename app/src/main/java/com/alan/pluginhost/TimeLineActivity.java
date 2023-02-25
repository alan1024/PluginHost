package com.alan.pluginhost;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class TimeLineActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.tl_fab)
    FloatingActionButton mFab;
    @BindView(R.id.collapsing_bar)
    CollapsingToolbarLayout mCtbLayout;
    @BindView(R.id.ca_swipeRefresh)
    SwipeRefreshLayout mRefreshLayout;

    /*
    界面数据
     */
    private List<TimeLineBean.TimelineInfo> mTimelineList;
    private int mCurrentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        Logger.init("TimeLineActivity");

        mToolbar.setTitle("社区");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置CollapsingToolbarLayout的信息
        mCtbLayout.setTitle("社区");
        mCtbLayout.setCollapsedTitleTextColor(Color.WHITE);
        mCtbLayout.setExpandedTitleColor(Color.WHITE);
        mCtbLayout.setExpandedTitleMarginStart(40);
        mCtbLayout.setExpandedTitleMarginBottom(30);

        if (Config.login_status) {
            getTimelineInfoFromServer();
        } else {
            Toast.makeText(TimeLineActivity.this, "请登录", Toast.LENGTH_SHORT).show();
        }
        setListener();

        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        });
        mRefreshLayout.setColorSchemeResources(R.color.colorYellow);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getTimelineInfoFromServer();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void timelineEvent(TimeLineEvent event) {
        if (event.flag == 1) {
            getTimelineInfoFromServer();
        }
    }

    private void setListener() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckInfoComplete.check(TimeLineActivity.this)) {
                    startActivity(new Intent(TimeLineActivity.this, PublishTLActivity.class));
                } else {
                    Toast.makeText(TimeLineActivity.this, "为保证社区质量，请完善个人信息", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getTimelineInfoFromServer() {
        OkHttpUtils.post()
                .url(Config.LOCAL_URL)
                .addParams(Config.ACTION, Config.ACTION_GET_TIMELINE)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(TimeLineActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                        mRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mRefreshLayout.setRefreshing(false);
                        if (!TextUtils.isEmpty(response)) {
                            parseData(response);
                        }
                    }
                });
    }

    private void parseData(String response) {
        Gson gson = new Gson();
        TimeLineBean timeLineBean = gson.fromJson(response, TimeLineBean.class);
        int status = timeLineBean.status;
        if (status == 1) {
            mTimelineList = timeLineBean.timeline;
            TimelineAdapter mAdapter = new TimelineAdapter(mTimelineList);
            mRecycler.setLayoutManager(new LinearLayoutManager(this));
            mRecycler.setAdapter(mAdapter);

            mRecycler.smoothScrollToPosition(mCurrentPosition);
        } else {
            Toast.makeText(TimeLineActivity.this, "社区还未有人发布消息", Toast.LENGTH_SHORT).show();
        }
    }

    public class TimelineAdapter extends BaseQuickAdapter<TimeLineBean.TimelineInfo, BaseViewHolder> {

        public TimelineAdapter(List<TimeLineBean.TimelineInfo> data) {
            super(R.layout.timeline_item_layout, data);
        }

        @Override
        protected void convert(BaseViewHolder holder, TimeLineBean.TimelineInfo timeLineBean) {
            holder.setOnClickListener(R.id.tl_item_layout, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            holder.setText(R.id.tl_nickname, timeLineBean.nickname);
            holder.setText(R.id.tl_area, timeLineBean.city);
            holder.setText(R.id.tl_content, timeLineBean.content);
            holder.setText(R.id.tl_comment_count, timeLineBean.cmCount + "");
            String times = DateFormatUtils.getTimesToNow(timeLineBean.date);
            holder.setText(R.id.tl_date, times);
            if (timeLineBean.sex.equals("女")) {
                holder.setImageResource(R.id.tl_sex_icon, R.drawable.female);
            } else {
                holder.setImageResource(R.id.tl_sex_icon, R.drawable.male);
            }

            if (!TextUtils.isEmpty(timeLineBean.headUrl)) {
                Glide.with(TimeLineActivity.this)
                        .load(timeLineBean.headUrl)
                        .centerCrop()
                        .crossFade()
                        .into((ImageView) holder.getView(R.id.tl_head_image));
            }
        }
    }
}

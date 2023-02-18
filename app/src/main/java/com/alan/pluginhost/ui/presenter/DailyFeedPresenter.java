package com.alan.pluginhost.ui.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.bean.daily.DailyTimeLine;
import com.alan.pluginhost.di.scope.ContextLife;
import com.alan.pluginhost.ui.contract.DailyFeedContract;

import javax.inject.Inject;

public class DailyFeedPresenter extends BasePresenter<DailyFeedContract.View> implements DailyFeedContract.Presenter {
    private Context mContext;
    private String mId;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private int lastVisibleItem;
    //是否有更多
    private String has_more;
    //下一页
    private String next_pager;
    private boolean isLoadMore = false; // 是否加载过更多
    private DailyTimeLine timeLine;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Inject
    public DailyFeedPresenter(@ContextLife Context context) {
        this.mContext = context;
    }


    @Override
    public void getDailyFeedDetail(String id, String num) {
        this.mId = id;
        if (mView != null) {
        }
    }

    private void disPlayDailyTimeLine(Context context, DailyTimeLine dailyTimeLine) {
        if (dailyTimeLine.getResponse().getLast_key() != null) {
            next_pager = dailyTimeLine.getResponse().getLast_key();
            has_more = dailyTimeLine.getResponse().getHas_more();
        }
        if (isLoadMore) {
            if (dailyTimeLine.getResponse().getOptions() == null) {
                mView.setDataRefresh(false);
                return;
            } else {
                timeLine.getResponse().getOptions().addAll(dailyTimeLine.getResponse().getOptions());
            }
        } else {
            timeLine = dailyTimeLine;
        }
        mView.setDataRefresh(false);
        mView.hideLoading();
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        mView.setDataRefresh(false);
    }

    public void scrollRecycleView() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = mLayoutManager
                            .findLastVisibleItemPosition();
                    if (mLayoutManager.getItemCount() == 1) {
                        return;
                    }
                    if (lastVisibleItem + 1 == mLayoutManager
                            .getItemCount()) {
                        if (has_more.equals("true")) {
                            isLoadMore = true;
                            mView.setDataRefresh(true);
                            mHandler.postDelayed(() -> getDailyFeedDetail(mId, next_pager), 1000);
                        }
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
    }
}

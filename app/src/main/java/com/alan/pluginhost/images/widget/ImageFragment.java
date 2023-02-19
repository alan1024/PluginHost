package com.alan.pluginhost.images.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alan.pluginhost.beans.ImageBean;
import com.alan.pluginhost.images.ImageAdapter;
import com.alan.pluginhost.images.presenter.ImagePresenter;
import com.alan.pluginhost.images.presenter.ImagePresenterImpl;
import com.alan.pluginhost.images.view.ImageView;

import java.util.ArrayList;
import java.util.List;


public class ImageFragment extends Fragment
        implements ImageView, SwipeRefreshLayout.OnRefreshListener {
    private final static String TAG = "ImageFragment";

    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecycleView;
    private LinearLayoutManager mLayoutManager;
    private List<ImageBean> mDatas;
    private ImagePresenter mImagePresenter;
    private ImageAdapter mAdapter;

    private boolean mIsRefreshing = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImagePresenter = new ImagePresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStata) {
//        View view = inflater.inflate(R.layout.fragment_image,container,false);
//        mSwipeRefreshWidget = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_widget);
//        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
//                R.color.primary_dark,R.color.primary_light,
//                R.color.accent);
//        mSwipeRefreshWidget.setOnRefreshListener(this);
//
//        mRecycleView = (RecyclerView)view.findViewById(R.id.recycle_view);
//        mRecycleView.setHasFixedSize(true);
//
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecycleView.setLayoutManager(mLayoutManager);
//
//        mRecycleView.setItemAnimator(new DefaultItemAnimator());
//        mAdapter = new ImageAdapter(getActivity());
//        mRecycleView.setAdapter(mAdapter);
//        mRecycleView.addOnScrollListener(mOnScrollListener);
//        mRecycleView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(mSwipeRefreshWidget.isRefreshing()){
//                    //返回true表示该事件已经被消耗，不需传递给后续handler
//                    return true;
//                }else{
//                    return false;
//                }
//            }
//        });
        onRefresh();

        return null;
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        private int lastVisibleItem;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount()) {
//                Snackbar.make(getActivity().findViewById(R.id.drawer_layout)
//                        ,getString(R.string.image_hit),Snackbar.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }
    };

    @Override
    public void onRefresh() {
        if (mDatas != null) {
            mDatas.clear();
        }
        mImagePresenter.loadImageList();
    }

    @Override
    public void addImages(List<ImageBean> images) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.addAll(images);
        mAdapter.setDatas(mDatas);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {
//        View view = getActivity() == null ?
//                mRecycleView.getRootView() : getActivity().findViewById(R.id.drawer_layout);
//
//        Snackbar.make(view,getString(R.string.load_fail),Snackbar.LENGTH_SHORT).show();
    }
}

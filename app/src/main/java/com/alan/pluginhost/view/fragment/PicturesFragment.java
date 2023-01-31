package com.alan.pluginhost.view.fragment;

import android.view.View;

import com.alan.pluginhost.adapter.PictureGridAdapter;
import com.alan.pluginhost.delegate.PicturesFragmentDelegate;
import com.alan.pluginhost.delegate.SwipeRefreshAndLoadMoreCallBack;
import com.alan.pluginhost.model.entity.PictureBody;
import com.alan.pluginhost.model.pictures.PicturesModel;
import com.alan.pluginhost.model.pictures.PicturesModelImpl;
import com.alan.pluginhost.mvp_frame.presenter.FragmentPresenter;

import java.util.ArrayList;
import java.util.List;


public class PicturesFragment extends FragmentPresenter<PicturesFragmentDelegate> implements SwipeRefreshAndLoadMoreCallBack, PicturesFragmentDelegate.FloatingActionButtonListener {
    private PicturesModel mPicturesModel;
    private PictureGridAdapter mPictureGridAdapter;

    private int mPageNum = 1;
    private String mPictureId = PicturesModel.DEFAULT_TYPE;

    private List<PictureBody> mList = new ArrayList<>();

    public static PicturesFragment newInstance() {
        PicturesFragment fragment = new PicturesFragment();
        return fragment;
    }

    @Override
    protected Class<PicturesFragmentDelegate> getDelegateClass() {
        return PicturesFragmentDelegate.class;
    }

    @Override
    protected void initData() {
        super.initData();
        mPicturesModel = new PicturesModelImpl();
        mPictureGridAdapter = new PictureGridAdapter(mList, getActivity());
        mPictureGridAdapter.setOnImageClickListener(new PictureGridAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(View view, int position) {
                viewDelegate.showDialog(mList.get(position).getList().get(0).getBig());
            }
        });

        viewDelegate.setListAdapter(mPictureGridAdapter);

        //注册下拉刷新
        viewDelegate.registerSwipeRefreshCallBack(this);
        //注册加载更多
        viewDelegate.registerLoadMoreCallBack(this, mPictureGridAdapter);

        netLoadPictures(mPictureId, true);
    }

    @Override
    protected void initView() {
        super.initView();
        viewDelegate.setFloatingActionButtonListener(this);
    }

    /**
     * 网络获取图片
     */
    private void netLoadPictures(String id, final boolean isRefresh) {
        if (isRefresh) {
            mPageNum = 1;
        } else {
            mPageNum++;
        }


        /*mPicturesModel.netLoadPicturesByOpenApi(mPageNum, 20).compose(
                new NetTransformer<OpenApiResponse<List<OpenApiPicture>>, List<OpenApiPicture>>(this))
                .subscribe(new Observer<List<OpenApiPicture>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        viewDelegate.showRefreshLayout();
                    }

                    @Override
                    public void onNext(List<OpenApiPicture> openApiPictures) {
                        viewDelegate.showContent();
                        if (isRefresh) {
                            if (!mList.isEmpty()) {
                                mList.clear();
                            }
                        }
                        mList.addAll(openApiPictures);
                        mPictureGridAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        viewDelegate.showError(R.string.load_error, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                netLoadPictures(mPictureId, true);
                            }
                        });
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

        /*mPicturesModel.netLoadPicturesByOpenApi(mPageNum, 20, new OnNetRequestListener<List<OpenApiPicture>>() {
            @Override
            public void onStart() {
                viewDelegate.showRefreshLayout();
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(List<OpenApiPicture> data) {
                viewDelegate.showContent();
                if (isRefresh) {
                    if (!mList.isEmpty()) {
                        mList.clear();
                    }
                }
                mList.addAll(data);
                mPictureGridAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {
                viewDelegate.showError(R.string.load_error, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        netLoadPictures(mPictureId, true);
                    }
                });
            }
        });*/
    }

    @Override
    public void refresh() {
        netLoadPictures(mPictureId, true);
    }

    @Override
    public void loadMore() {
        netLoadPictures(mPictureId, false);
    }

    @Override
    public void onClick(String id) {
        mPictureId = id;
        refresh();
    }
}

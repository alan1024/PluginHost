package com.alan.pluginhost;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class PicActivity extends AppCompatActivity {

    @BindView(R.id.pic_recycler)
    RecyclerView mRecycler;

    @BindView(R.id.pic_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pic);
        ButterKnife.bind(this);
        Logger.init("PicActivity");

        mToolbar.setTitle("图集");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getDataFromServer();
    }

    private void getDataFromServer() {
        OkHttpUtils.get()
                .url(Config.GET_PICTURE_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.d("getDataFromServer" + response);
                        ParseData(response);
                    }
                });
    }

    public void ParseData(String response) {

        Gson gson = new Gson();
        PictureBean.Picture picture = gson.fromJson(response, PictureBean.class).pictures;
        final List<PictureBean.Pic> mPicDetailList = picture.data;
        Logger.d(mPicDetailList.get(0).title);
        List<PicBean> picList = new ArrayList<>();
        for (int i = 0; i < mPicDetailList.size(); i++) {
            PicBean bean = new PicBean();
            bean.picUrl = mPicDetailList.get(i).first_pic;
            bean.picTitle = mPicDetailList.get(i).title;
            picList.add(bean);
        }

        PicAdapter adapter = new PicAdapter(picList);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(manager);
        mRecycler.setAdapter(adapter);


    }

    public class PicAdapter extends BaseQuickAdapter<PicBean, BaseViewHolder> {

        public PicAdapter(List<PicBean> picList) {
            super(R.layout.pic_item_layout, picList);
        }

        @Override
        protected void convert(BaseViewHolder helper, PicBean picBean) {
            helper.setText(R.id.pic_text, picBean.picTitle);
            String url = Config.PICTURE_URL + picBean.picUrl;
            Glide.with(mContext)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.login)
                    .crossFade()
                    .into((ImageView) helper.getView(R.id.pic_image));

            helper.setOnClickListener(R.id.pic_item, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}

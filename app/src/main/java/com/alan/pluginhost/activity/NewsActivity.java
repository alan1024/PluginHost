package com.alan.pluginhost.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.alan.pluginhost.R;
import com.alan.pluginhost.news.comments.Comment;
import com.alan.pluginhost.view.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;


public class NewsActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView mWebViewNews;
    private ProgressBar mPbProgress;
    private ImageView mIvBack;
    private ImageView mIvStopLoading;
    private ListView mLvCommentList;
    private ListViewForScrollView mLsCommentList;
    private int mRefreshNum = 0;
    private boolean mIsLastRow = true;
    private List<Comment> mCommentList;
    private LinearLayout mLlFooterView;
    private ScrollView mScrollView;
    private TextView mTextViewMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mCommentList = new ArrayList<>();

        mWebViewNews = (WebView) findViewById(R.id.wvNews);
        mPbProgress = (ProgressBar) findViewById(R.id.pbProgress);
        mIvBack = (ImageView) findViewById(R.id.ivWebViewBack);
        mIvStopLoading = (ImageView) findViewById(R.id.ivStopLoading);
        mLsCommentList = (ListViewForScrollView) findViewById(R.id.lvComments);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);

        mTextViewMore.setText("加载更多…………");

        mIvBack.setOnClickListener(this);
        mIvStopLoading.setOnClickListener(this);
        Intent intent = getIntent();
        final String url = intent.getStringExtra("news_url");
        mWebViewNews.getSettings().setJavaScriptEnabled(true);
//        mWebViewNews.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        mWebViewNews.getSettings().setBlockNetworkImage(false);
//        mWebViewNews.getSettings().setDomStorageEnabled(true);
        mWebViewNews.getSettings().setAllowFileAccess(true);
        mWebViewNews.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebViewNews.getSettings().setLoadWithOverviewMode(true);
        mWebViewNews.getSettings().setUseWideViewPort(true);
        mWebViewNews.getSettings().setDisplayZoomControls(true);// 设置显示缩放按钮
        mWebViewNews.getSettings().setSupportZoom(true); // 支持缩放
        mWebViewNews.getSettings().setBuiltInZoomControls(true);
        mWebViewNews.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                NewsActivity.this.setTitle("加载中，请稍后...");
//                System.out.println("newProgress是"+newProgress);
                if (newProgress == 100) {
//                    mRequestQueue.add(getCommentsData(url,0+"",10+"",mLsCommentList));

                    mPbProgress.setVisibility(View.GONE);
                    mIvStopLoading.setVisibility(View.INVISIBLE);
                } else {
                    if (mPbProgress.getVisibility() == View.GONE) {
                        mPbProgress.setVisibility(View.VISIBLE);
                    }
                    mPbProgress.setProgress(newProgress);
                    mIvStopLoading.setVisibility(View.VISIBLE);

                }
            }
        });
        mWebViewNews.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

        });

        mWebViewNews.loadUrl(url);

        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE:

                        break;
                    case MotionEvent.ACTION_UP:
                        int scrollY = view.getScrollY();
                        int height = view.getHeight();
                        int scrollViewMeasuredHeight = mScrollView.getChildAt(0).getMeasuredHeight();
                        if ((scrollY + height) == scrollViewMeasuredHeight) {
                            if (mIsLastRow) {
                                mRefreshNum++;

                            }
                        }
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebViewNews.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebViewNews.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebViewNews != null)
            mWebViewNews.destroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivWebViewBack:
                finish();
                break;
            case R.id.ivStopLoading:
                mWebViewNews.stopLoading();
                break;
        }
    }

    /*
     * 获取新闻评论
     * */
    public String getCommentsData(String baseUrl, String parameter1, String parameter2,
                                  final ListView listView) {
        String url = baseUrl + "comments/?count=10&page=" + parameter1 + "&offset=" + parameter2
                + "&item_id=0&format=json";
        System.out.println("访问的Url为" + url);

//        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url.trim(), null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try{
//                            System.out.println("Volley得到的response是+"+response.toString());
//                            Gson gson = new Gson();
//
//                            CommentsData commentsData= gson.fromJson(response.toString(),new TypeToken<CommentsData>(){}.getType());
//                            List<Comment> commentList=new ArrayList<>();
//                            if (commentsData.getMessage().equals("success")){
//                                commentList=commentsData.getData().getComments();
//                                System.out.println("当前获取的commentList是"+commentList.size());
//                                if (commentList.size()>0) {
//                                    mCommentList.addAll(commentList);
//                                }else {
//                                    mIsLastRow=false;
//                                    mTextViewMore.setText("已没有更多评论");
//                                }
//                            }else {
//                                mIsLastRow=false;
//                                mTextViewMore.setText("已没有更多评论");
//
//                            }
//
//                            CommentsAdapter adapter=new CommentsAdapter(NewsActivity.this,
//                                    mCommentList,mRequestQueue);
//                            if (mCommentList.size()>10){
//                                listView.removeFooterView(mLlFooterView);
//                            }
//                            listView.addFooterView(mLlFooterView);
//
//                            listView.setAdapter(adapter);
//                            adapter.notifyDataSetChanged();
//
//
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("获取信息失败……");
//                System.out.println("error是"+error.toString());
//                mIsLastRow=false;
//                mTextViewMore.setText("已没有更多评论");
//                listView.addFooterView(mLlFooterView);
//            }
//        });

        System.out.println("jsonObjectRequest");
        return "";
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }


}

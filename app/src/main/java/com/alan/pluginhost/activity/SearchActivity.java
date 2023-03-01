package com.alan.pluginhost.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.alan.pluginhost.R;
import com.alan.pluginhost.news.Data;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvBack;
    private EditText mEtInput;
    private ImageView mIvClear;
    private TextView mTvSearch;
    private ListView mLvSearchResult;
    private ProgressBar mProgressBar;


    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initView();


    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.ivBack);
        mEtInput = (EditText) findViewById(R.id.etInput);
        mIvClear = (ImageView) findViewById(R.id.ivClearText);
        mTvSearch = (TextView) findViewById(R.id.tvSearchEnsure);
        mLvSearchResult = (ListView) findViewById(R.id.lvSearchResult);
        mProgressBar = (ProgressBar) findViewById(R.id.pbSearchProgress);

        mTvSearch.setClickable(true);
        mTvSearch.setOnClickListener(this);
        mIvClear.setOnClickListener(this);
        mIvBack.setOnClickListener(this);

        mEtInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mEtInput.setFocusable(true);
                mEtInput.setFocusableInTouchMode(true);
                mEtInput.requestFocus();
                return false;
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ivClearText:
                mEtInput.setText("");
                break;
            case R.id.tvSearchEnsure:
                mProgressBar.setVisibility(View.VISIBLE);
                mEtInput.setFocusable(false);
                mEtInput.setFocusableInTouchMode(false);
                mEtInput.clearFocus();
                if (data != null) {
                    mLvSearchResult.setVisibility(View.INVISIBLE);
                }

                break;
        }
    }


    public String getNewsData(String baseUrl, final String parameter, final ListView listView) {
        System.out.println("访问的Url为" + (baseUrl + parameter));
//        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest((baseUrl + parameter).trim(), null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try{
//                            System.out.println("Volley得到的response是+"+response.toString());
//                            Gson gson = new Gson();
//                            data=gson.fromJson(response.toString(),new TypeToken<Data>(){}.getType());
//                            List<News> newsList =new ArrayList<>();
//                            newsList=data.getData();
//                            System.out.println("newsList的size是"+newsList.size());
//                            mProgressBar.setVisibility(View.GONE);
//                            mLvSearchResult.setVisibility(View.VISIBLE);
//                            NewsAdapter adapter=new NewsAdapter(SearchActivity.this,newsList,1,parameter);
//                            listView.setAdapter(adapter);
//                            adapter.notifyDataSetChanged();
//
//                            final List<News> finalNewsList = newsList;
//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    Intent intent=new Intent(SearchActivity.this, NewsActivity.class);
//                                    System.out.println("i的位置"+i);
//                                    System.out.println("newsList的size"+ finalNewsList.size());
//                                    System.out.println("newsList.get(i).getDisplay_url()"+ finalNewsList.get(i).getDisplay_url());
//                                    intent.putExtra("news_url", finalNewsList.get(i).getDisplay_url());
//                                    startActivity(intent);
//                                }
//                            });
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
//
//            }
//        });


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
            );
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

}

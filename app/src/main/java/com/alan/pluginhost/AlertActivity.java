package com.alan.pluginhost;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class AlertActivity extends AppCompatActivity {

    @BindView(R.id.alert_recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        ButterKnife.bind(this);
        Logger.d("AlertActivity");

        mToolbar.setTitle("回复我的");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String flag = getIntent().getStringExtra("from");
        if (flag.equals("Main")) {
            int nowCommCount = getIntent().getIntExtra("nowCommCount", 0);
            insertCommCount(nowCommCount);
            List<MyCommentBean.Comments> commentsList = (List<MyCommentBean.Comments>) getIntent().getSerializableExtra("commList");
            if (commentsList.size() == 0) {
                Toast.makeText(AlertActivity.this, "当前没有未处理的消息", Toast.LENGTH_SHORT).show();
            }
            initData(commentsList);
        } else {
            getCommentFromServer();
        }
    }

    private void insertCommCount(int nowCommCount) {
        OkHttpUtils.post()
                .url(Config.LOCAL_URL)
                .addParams(Config.ACTION, Config.ACTION_ADD_COMMENT_COUNT)
                .addParams(Config.USERNAME, Config.login_name)
                .addParams("commCount", nowCommCount + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject jObject = new JSONObject(response);
                            int status = jObject.getInt(Config.STATUS);
                            if (status == 1) {
                                EventBus.getDefault().post(new Alert2MainEvent(new ArrayList<MyCommentBean.Comments>()));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void getCommentFromServer() {
        OkHttpUtils.post()
                .url(Config.LOCAL_URL)
                .addParams(Config.ACTION, Config.ACTION_GET_USER_COMMENT)
                .addParams(Config.USERNAME, Config.login_name)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        MyCommentBean bean = gson.fromJson(response, MyCommentBean.class);
                        int status = bean.status;
                        if (status == 1) {
                            List<MyCommentBean.Comments> commList = bean.comments;
                            initData(commList);
                        } else {
                            Toast.makeText(AlertActivity.this, "暂时没有人回复您的帖子", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void initData(final List<MyCommentBean.Comments> commentsList) {


    }


}

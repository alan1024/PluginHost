package com.alan.pluginhost.delegate;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.adapter.WeatherAdapter;
import com.alan.pluginhost.mvp_frame.view.AppDelegate;
import com.alan.pluginhost.view.LoadingView;
import com.alan.pluginhost.widget.ProgressLayout;

import butterknife.BindView;

public class WeatherFragmentDelegate extends AppDelegate implements LoadingView {

    @BindView(R.id.progress_layout)
    ProgressLayout mProgressLayout;
    @BindView(R.id.et_location)
    EditText et_location;
    @BindView(R.id.rv_weather)
    RecyclerView rv_weather;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_weather;
    }

    /**
     * 获取输入的地名
     *
     * @return
     */
    public String getInputLocation() {
        return et_location.getText().toString();
    }

    /**
     * 初始化RecyclerView
     */
    public void initRecyclerView(WeatherAdapter adapter) {
        rv_weather.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_weather.setAdapter(adapter);
    }

    /**
     * 关闭软键盘
     */
    public void closeSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(et_location.getWindowToken(), 0);
    }

    @Override
    public void showLoading() {
        mProgressLayout.showLoading();
    }

    @Override
    public void showContent() {
        if (!mProgressLayout.isContent()) {
            closeSoftInput();
            mProgressLayout.showContent();
        }
    }

    @Override
    public void showError(int messageId, View.OnClickListener listener) {
        closeSoftInput();
        mProgressLayout.showError(messageId, listener);
    }
}

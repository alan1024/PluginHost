package com.alan.pluginhost.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alan.pluginhost.common.DefineView;
import com.alan.pluginhost.entity.CategoriesBean;
import com.alan.pluginhost.fragment.base.BaseFragment;

public class PageFragment extends BaseFragment implements DefineView {
    private View mView;
    private static final String KEY = "EXTRA";
    private CategoriesBean categoriesBean;
    private TextView tv_page;

    public static PageFragment newInstance(CategoriesBean extra) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, extra);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            categoriesBean = (CategoriesBean) bundle.getSerializable(KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            initView();
            initValidata();
            initListener();
            bindData();
        }
        return mView;
    }

    @Override
    public void initView() {
        tv_page.setText(categoriesBean.getTitle());
    }

    @Override
    public void initValidata() {
    }

    @Override
    public void initListener() {

    }

    @Override
    public void bindData() {

    }
}

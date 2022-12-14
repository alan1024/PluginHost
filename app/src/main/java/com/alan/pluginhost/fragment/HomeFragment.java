package com.alan.pluginhost.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alan.pluginhost.common.DefineView;
import com.alan.pluginhost.entity.AdHeadBean;
import com.alan.pluginhost.entity.CategoriesBean;
import com.alan.pluginhost.entity.HomeNewsBean;
import com.alan.pluginhost.fragment.base.BaseFragment;

import java.util.List;

public class HomeFragment extends BaseFragment implements DefineView {
    private View mView;
    private static final String KEY = "EXTRA";
    private CategoriesBean categoriesBean;
    private List<HomeNewsBean> homeNewsBeans;
    private List<AdHeadBean> adHeadBeans;
    private String[] masks;
    private int[] mask_colors;
    private FrameLayout home_framelayout;
    private LinearLayout loading, empty, error;
    private View headView;
    private LayoutInflater mInflater;
    private int gallerySelectedPositon = 0;//Gallery索引
    private int circleSelectedPosition = 0; // 默认指示器的圆圈的位置为第一

    public static HomeFragment newInstance(CategoriesBean extra) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, extra);
        HomeFragment fragment = new HomeFragment();
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
        }
        return mView;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initValidata() {
        masks = new String[]{"氪TV", "O2O", "新硬件", "Fun!!", "企业服务", "Fit&Health", "在线教育", "互联网金融", "大公司", "专栏"};

    }

    @Override
    public void initListener() {

    }

    @Override
    public void bindData() {
        int topSize = adHeadBeans.size();

    }

    /**
     * AutoGallery的自定义Adapter
     */
    class GalleryAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int position) {
            return adHeadBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder _Holder = null;
            if (convertView == null) {
                _Holder = new Holder();
                convertView.setTag(_Holder);
            } else {
                _Holder = (Holder) convertView.getTag();
            }
            //显示数据
            return convertView;
        }
    }

    private static class Holder {
        ImageView item_head_gallery_img;
    }
}

package com.alan.pluginhost.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.bean.NewsData;

import java.util.List;

public class LeftMenuFragment extends BaseFragment {

    private ListView lvMenu;
    private List<NewsData.NewsMenuData> mMenuList;
    private int mCurrentPos;//当前选择的item
    private LvMenuAdapter mLvMenuAdapter;

    @Override
    public View initViews() {

        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);

        lvMenu = (ListView) view.findViewById(R.id.lv_menu);


        return view;
    }

    /**
     * 得到网络获取的数据
     */
    public void getMenuData(NewsData newsData) {
        System.out.println("侧边栏得到数据：" + newsData);
        mMenuList = newsData.data;
        mLvMenuAdapter = new LvMenuAdapter();
        lvMenu.setAdapter(mLvMenuAdapter);
    }

    @Override
    public void initData() {
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentPos = position;
                mLvMenuAdapter.notifyDataSetChanged();//重新刷新数据

                setCurrentMenuDetailPager(position);//设置当前对应的菜单详情页

                toggleSlidingMenu();
            }
        });
    }

    /**
     * 切换SlidingMenu开关状态
     */
    private void toggleSlidingMenu() {
    }

    /**
     * 设置当前对应的菜单详情页
     *
     * @param position
     */
    private void setCurrentMenuDetailPager(int position) {
    }

    /**
     * 侧边栏数据适配器
     */
    class LvMenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mMenuList.size();
        }

        @Override
        public Object getItem(int position) {
            return mMenuList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mActivity, R.layout.list_leftmenu, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);

            tvTitle.setText(mMenuList.get(position).title);
            if (mCurrentPos == position) {
                tvTitle.setEnabled(true);
            } else {
                tvTitle.setEnabled(false);
            }

            return view;
        }
    }
}

package com.alan.pluginhost.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.alan.pluginhost.R;
import com.alan.pluginhost.adapter.NewsAdapter;
import com.alan.pluginhost.news.Data;
import com.alan.pluginhost.news.News;
import com.alan.pluginhost.util.NetWorkState;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


public class HomeFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mIvSearch;
    private List<View> mViewList;
    private static List<News> newsList;
    private Data data;//获取数据
    private int mType;//首页/视频
    private boolean isFirstScroll = true;
    private NewsAdapter mNewsAdapter;
    private int mNewsType = 1;//1.新闻  2.视频   3.段子   4.图片
//    private boolean mNetState;//网络状态


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.title_tab);
        mViewPager = (ViewPager) view.findViewById(R.id.content_viewpage);
        mIvSearch = (ImageView) view.findViewById(R.id.ivSearch);

        if (getArguments() != null) {
            mType = getArguments().getInt("TYPE");
        }
//        mNetState= NetWorkState.isConn(getActivity());
        Log.e("MainActivity:  ", NetWorkState.mNetState + "");

        if (NetWorkState.mNetState) {
            if (mType == 0) {
                showFragment(inflater);
            } else if (mType == 1) {
                showVideoFragment(inflater);
            }
        }

        return view;
    }

    public static HomeFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("TYPE", type);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    /*
     * 首页内容Fragment
     * */
    private void showFragment(LayoutInflater inflater) {
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        String[] tabTitleList = getResources().getStringArray(R.array.home_tab_title_list);
//        mViewList = new ArrayList<>();
//
//        for (int i = 0; i < tabTitleList.length; i++) {
//            mTabLayout.addTab(mTabLayout.newTab().setText(tabTitleList[i]));
//            View view1 = inflater.inflate(R.layout.view_content, null);
//            mViewList.add(view1);
//        }
//
//        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
//
//        HomePagerAdapter adapter = new HomePagerAdapter(mViewList, tabTitleList);
//        mViewPager.setAdapter(adapter);
//        View view = mViewList.get(0);
//        //默认首页的展示
//        final ListView listView = (ListView) view.findViewById(R.id.lvNewsList);
//        requestQueue.add(getNewsData("http://toutiao.com/api/article/recent/" +
//                "?source=2&category=__all__&as=A1C5D7A9962A7C9&cp=57967A97AC793E1", "", listView));
//        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srRefresh);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                requestQueue.add(getNewsData("http://toutiao.com/api/article/recent/" +
//                                "?source=2&category=__all__&as=A105177907376A5" +
//                                "&cp=5797C7865AD54E1&_="
//                        , data.getNext().getMax_behot_time() + "", listView, refreshLayout));
//            }
//        });
//
//        //viewPager页面间的切换
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(final int position) {
//                System.out.println("onPageSelected的位置是" + position);
//                View view = mViewList.get(position);
//                final ListView listView = (ListView) view.findViewById(R.id.lvNewsList);
//                final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srRefresh);
//                refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.
//                                R.color.holo_red_light, android.R.color.holo_orange_light,
//                        android.R.color.holo_green_light);
//
//
//                refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                    @Override
//                    public void onRefresh() {
//                        showNews(position, requestQueue, listView, refreshLayout);
//                    }
//                });
//
//                refreshLayout.setRefreshing(true);
//                showNews(position, requestQueue, listView, refreshLayout);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        mTabLayout.setupWithViewPager(mViewPager);

    }

    /*
     * 视频内容Fragment
     * */
    private void showVideoFragment(LayoutInflater inflater) {
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        String[] tabTitleList = getResources().getStringArray(R.array.video_tab_title_list);
//        mViewList = new ArrayList<>();
//
//        for (int i = 0; i < tabTitleList.length; i++) {
//            mTabLayout.addTab(mTabLayout.newTab().setText(tabTitleList[i]));
//            View view1 = inflater.inflate(R.layout.view_content, null);
//            mViewList.add(view1);
//        }
//
//        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
//
//        HomePagerAdapter adapter = new HomePagerAdapter(mViewList, tabTitleList);
//        mViewPager.setAdapter(adapter);
//        View view = mViewList.get(0);
//        final ListView listView = (ListView) view.findViewById(R.id.lvNewsList);
//        requestQueue.add(getNewsData("http://toutiao.com/api/article/recent/?source=2&category=video" +
//                "&as=A165472AB9D6F61", "", listView));
//        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srRefresh);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                requestQueue.add(getNewsData("http://toutiao.com/api/article/recent/?source=2&category=video" +
//                                "&as=A165472AB9D6F61"
//                        , "", listView, refreshLayout));
//            }
//        });
//
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(final int position) {
//                System.out.println("onPageSelected的位置是" + position);
//                View view = mViewList.get(position);
//                final ListView listView = (ListView) view.findViewById(R.id.lvNewsList);
//                final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srRefresh);
//                refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.
//                                R.color.holo_red_light, android.R.color.holo_orange_light,
//                        android.R.color.holo_green_light);
//
//
//                refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                    @Override
//                    public void onRefresh() {
//                        showVideoNews(position, requestQueue, listView, refreshLayout);
//                    }
//                });
//
//                refreshLayout.setRefreshing(true);
//                showNews(position, requestQueue, listView, refreshLayout);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        mTabLayout.setupWithViewPager(mViewPager);

    }

//    /*
//    * 获取首页相关内容
//    * */
//    public void showNews(int position, RequestQueue requestQueue, ListView listView,
//                         SwipeRefreshLayout refreshLayout) {
//        String url = null;
//        if (position == 4) {//段子的内容与其他不一样，单独处理
//            url = "http://toutiao.com/api/article/recent/" +
//                    "?source=2&category=essay_joke&as=A1B5276908B3CCE";
//            requestQueue.add(getJokeData(url, "", listView, refreshLayout));
//            mNewsType = 3;
//        } else {
//            switch (position) {
//                case 0:
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&category=__all__&as=A105177907376A5";
//                    break;
//                case 1:
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&category=news_hot&as=A1B5C75918C3A2C";
//                    break;
//                case 2:
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&category=video&as=A195A71998C3BBD";
//                    break;
//                case 3://社会
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&category=news_society&as=A145F7D98893D5A";
//                    break;
//                case 6://yule
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&category=news_entertainment&as=A1C507392893DCD&";
//                    break;
//                case 5://图片
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&count=20&category=gallery_detail&max_behot_time=" +
//                            "1469594722.33&utm_source=toutiao&device_platform=web" +
//                            "&offset=0&as=A1D5C7D9E873C62";
//                    break;
//                case 7:
//                    url = "http://toutiao.com/api/article/recent/" +
//                            "?source=2&category=news_tech&as=A1B5373998E3FCB";
//                    break;
//
//
//            }
//            mNewsType = 1;
//            requestQueue.add(getNewsData(url, "", listView, refreshLayout));
//        }
//    }
//
//    /*
//    * 获取视频内容
//    * */
//    public void showVideoNews(int position, RequestQueue requestQueue, ListView listView,
//                              SwipeRefreshLayout refreshLayout) {
//        String url = null;
//        switch (position) {
//            case 0://全部
//                url = "http://toutiao.com/api/article/recent/?source=2&category=video" +
//                        "&as=A165472AB9D6F61";
//                break;
//            case 1://逗比剧
//                url = "http://toutiao.com/api/article/recent/?source=2&category=subv_funny" +
//                        "&as=A1D507EA5937321";
//                break;
//            case 2://好声音
//                url = "http://toutiao.com/api/article/recent/?source=2&category=subv_voice" +
//                        "&as=A17517DA89C7341";
//                break;
//            case 3://看天下
//                url = "http://toutiao.com/api/article/recent/?source=2&category=subv_society" +
//                        "&as=A135F7CAF987379";
//                break;
//            case 4://小品
//                url = "http://toutiao.com/api/article/recent/?source=2&category=subv_comedy" +
//                        "&as=A175777A09F73B7";
//                break;
//            case 5://掠影
//                url = "http://toutiao.com/api/article/recent/?source=2&category=subv_movie" +
//                        "&as=A1D527BAD9973D2";
//                break;
//            case 6://最娱乐
//                url = "http://toutiao.com/api/article/recent/?source=2&category=subv_entertainment" +
//                        "&as=A175D7CA09173E7";
//                break;
//
//        }
//        requestQueue.add(getNewsData(url, "", listView, refreshLayout));
//    }
//
//    /*
//    * 获取连接返回的JSON数据，并解析的请求，内带更新的处理
//    * */
//    public JsonObjectRequest getNewsData(String baseUrl, String parameter, final ListView listView,
//                                         final SwipeRefreshLayout refreshLayout) {
//        System.out.println("访问的Url为" + (baseUrl + parameter));
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest((baseUrl + parameter).trim(), null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
////                            System.out.println("Volley得到的response是+" + response.toString());
//                            Gson gson = new Gson();
//                            data = gson.fromJson(response.toString(), new TypeToken<Data>() {
//                            }.getType());
//                            List<News> newsList;
//                            newsList = data.getData();
//
//                            refreshLayout.setRefreshing(false);
//                            System.out.println("newsList的size是" + newsList.size());
//                            mNewsAdapter = new NewsAdapter(getActivity(), newsList);
//                            listView.setAdapter(mNewsAdapter);
//                            mNewsAdapter.notifyDataSetChanged();
//
//                            final List<News> finalNewsList = newsList;
//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    Intent intent = new Intent(getActivity(), NewsActivity.class);
//                                    System.out.println("i的位置" + i);
//                                    System.out.println("newsList的size" + finalNewsList.size());
//                                    System.out.println("newsList.get(i).getDisplay_url()" + finalNewsList.get(i).getDisplay_url());
//                                    System.out.println("newsList.get(i).getArticle_url()" + finalNewsList.get(i).getArticle_url());
////                                    intent.putExtra("news_url", finalNewsList.get(i).getDisplay_url());
//                                    intent.putExtra("news_url", finalNewsList.get(i).getArticle_url());
//                                    startActivity(intent);
//                                }
//                            });
//                            listView.setOnScrollListener(new NewsListOnScrollListener());
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("获取信息失败……");
//                System.out.println("error是" + error.toString());
//
//            }
//        });
//        System.out.println("jsonObjectRequest" + jsonObjectRequest.toString());
//        return jsonObjectRequest;
//    }
//
//    /*
//    * 获取连接返回的JSON数据，并解析的请求
//    * */
//    public JsonObjectRequest getNewsData(String baseUrl, String parameter, final ListView listView) {
//        System.out.println("访问的Url为" + (baseUrl + parameter));
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest((baseUrl + parameter).trim(), null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            System.out.println("Volley得到的response是+" + response.toString());
//                            Gson gson = new Gson();
//                            data = gson.fromJson(response.toString(), new TypeToken<Data>() {
//                            }.getType());
//                            List<News> newsList;
//                            newsList = data.getData();
//                            System.out.println("newsList的size是" + newsList.size());
//                            mNewsAdapter = new NewsAdapter(getActivity(), newsList);
//                            System.out.println("isFirstScroll是" + isFirstScroll);
//                            listView.setAdapter(mNewsAdapter);
//                            System.out.println("listView.getLastVisiblePosition()是" + listView.getLastVisiblePosition());
//
//                            if (isFirstScroll) {
//                                mNewsAdapter.setLastPosition(listView.getLastVisiblePosition());
//                                isFirstScroll = false;
//                            }
//                            mNewsAdapter.notifyDataSetChanged();
//
//                            final List<News> finalNewsList = newsList;
//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    Intent intent = new Intent(getActivity(), NewsActivity.class);
//                                    System.out.println("i的位置" + i);
//                                    System.out.println("newsList的size" + finalNewsList.size());
//                                    System.out.println("newsList.get(i).getDisplay_url()" + finalNewsList.get(i).getDisplay_url());
//                                    intent.putExtra("news_url", finalNewsList.get(i).getDisplay_url());
//                                    startActivity(intent);
//                                }
//                            });
//                            listView.setOnScrollListener(new NewsListOnScrollListener());
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("获取信息失败……");
//                System.out.println("error是" + error.toString());
//
//            }
//        });
//
//        System.out.println("jsonObjectRequest" + jsonObjectRequest.toString());
//        return jsonObjectRequest;
//    }
//
//    /*
//    * 列表点击转入相应的新闻页面
//    * */
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Intent intent = new Intent(getActivity(), NewsActivity.class);
//        switch (mNewsType) {
//            case 3:
//
//                System.out.println("i的位置" + i);
//                System.out.println("newsList的size" + newsList.size());
//                System.out.println("newsList.get(i).getDisplay_url()" + newsList.get(i).getDisplay_url());
//                intent.putExtra("news_url", newsList.get(i).getDisplay_url());
//                startActivity(intent);
//                break;
//            default:
//                System.out.println("i的位置" + i);
//                System.out.println("newsList的size" + newsList.size());
//                System.out.println("newsList.get(i).getDisplay_url()" + newsList.get(i).getDisplay_url());
//                intent.putExtra("news_url", newsList.get(i).getDisplay_url());
//                startActivity(intent);
//                break;
//
//        }
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.ivSearch:
//                startActivity(new Intent(getActivity(), SearchActivity.class));
//                break;
//
//        }
//    }
//
//    /*
//    * ViewPager的适配器
//    * */
//    public class HomePagerAdapter extends PagerAdapter {
//        private List<View> mViewList;
//        private String[] title;
//
//        HomePagerAdapter(List<View> viewList, String[] title) {
//            mViewList = viewList;
//            this.title = title;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public int getCount() {
//            return mViewList.size();
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            View view = mViewList.get(position);
//
//            container.addView(view);
//            return view;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
////        super.destroyItem(container, position, object);
//            container.removeView(mViewList.get(position));
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            if (title == null) {
////            return super.getPageTitle(position);
//                return super.getPageTitle(position);
//            } else {
//                return title[position];
//            }
//        }
//    }
//
//    /*
//    * 列表的滚动处理
//    * */
//    public class NewsListOnScrollListener implements AbsListView.OnScrollListener {
//        private int position;
//
//        @Override
//        public void onScrollStateChanged(AbsListView view, int scrollState) {
//            switch (scrollState) {
//                case SCROLL_STATE_TOUCH_SCROLL:
//                    mNewsAdapter.setScroll(true);
////                    System.out.println("开始滚动");
//                    break;
//                case SCROLL_STATE_IDLE:
//                    mNewsAdapter.setScroll(false);
//                    mNewsAdapter.notifyDataSetChanged();
//                    mNewsAdapter.setScrollposition(position);
////                    System.out.println("停止滚动");
//                    break;
//            }
//        }
//
//        @Override
//        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//            position = firstVisibleItem + visibleItemCount;
//            mNewsAdapter.setStartPosition(firstVisibleItem);
//            mNewsAdapter.setStopPosition(firstVisibleItem + visibleItemCount);
//        }
//    }
//
//    /*
//    * 段子的数据单独处理
//    * */
//    public JsonObjectRequest getJokeData(String baseUrl, String parameter, final ListView listView
//            , final SwipeRefreshLayout refreshLayout) {
//        System.out.println("访问的Url为" + (baseUrl + parameter));
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest((baseUrl + parameter).trim(), null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            System.out.println("Volley得到的response是+" + response.toString());
//                            Gson gson = new Gson();
//                            JokeData jokeData = gson.fromJson(response.toString(), new TypeToken<JokeData>() {
//                            }.getType());
//                            List<Joke> jokeList = jokeData.getData();
//                            refreshLayout.setRefreshing(false);
//                            JokeAdapter adapter = new JokeAdapter(getActivity(), jokeList);
//                            listView.setAdapter(adapter);
//                            adapter.notifyDataSetChanged();
//                            final List<Joke> finalJokeList = jokeList;
//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                    Intent intent = new Intent(getActivity(), NewsActivity.class);
//                                    System.out.println("i的位置" + position);
//                                    System.out.println("newsList的size" + finalJokeList.size());
//                                    System.out.println("newsList.get(i).getDisplay_url()" + finalJokeList.get(position).getGroup().getShare_url());
//                                    intent.putExtra("news_url", finalJokeList.get(position).getGroup().getShare_url());
//                                    startActivity(intent);
//                                }
//                            });
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("获取信息失败……");
//                System.out.println("error是" + error.toString());
//
//            }
//        });
//
//        System.out.println("jsonObjectRequest" + jsonObjectRequest.toString());
//        return jsonObjectRequest;
//    }


}

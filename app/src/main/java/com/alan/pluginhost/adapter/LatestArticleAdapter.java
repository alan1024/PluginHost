package com.alan.pluginhost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alan.pluginhost.R;
import com.alan.pluginhost.model.SimpleArticleItem;
import com.alan.pluginhost.util.Constant;
import com.alan.pluginhost.util.OnItemClickLitener;

import java.util.ArrayList;
import java.util.List;


public class LatestArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final static int TYPE_MULTI_IMAGES = 3; // 多个图片的文章
    public final static int TYPE_FOOTER = 4;//底部--往往是loading_more
    public final static int TYPE_NORMAL = 2; // 正常的一条文章
    private static final int TYPE_ROTATION = 1;
    //Handler 用到的参数值
    private static final int UPTATE_VIEWPAGER = 0;

    //新闻列表
    private List<SimpleArticleItem> articleList;

    //设置当前 第几个图片 被选中
    private int currentIndex = 0;

    //context
    private Context context;

    private LayoutInflater mLayoutInflater;

    private ImageView[] mCircleImages;//底部只是当前页面的小圆点

    private OnItemClickLitener mOnItemClickLitener;//点击 RecyclerView 中的 Item


    /**
     * 注意这儿的 articleList 和原来的articleList 是同一个引用
     * fragment 的文章list增加了数据
     * 这儿的list也增加数据
     *
     * @param context
     * @param articleList
     */
    public LatestArticleAdapter(Context context, List<SimpleArticleItem> articleList) {
        this.context = context;

        if (articleList == null) {
            this.articleList = new ArrayList<SimpleArticleItem>();
        } else {
            //头部viewpager图片固定是7张，剩下的是列表的数据
            this.articleList = articleList;
        }

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //理论上应该把最可能返回的 TYPE 放在前面

        RecyclerView.ViewHolder vh;
        View view;
        switch (viewType) {

            //其他无法处理的情况使用viewholder_article_simple
            default:
            case TYPE_NORMAL:
                view = mLayoutInflater.inflate(R.layout.item_article_normal, parent, false);
                vh = new ItemArticleViewHolder(view);
                return vh;
            case TYPE_FOOTER:
                view = mLayoutInflater.inflate(R.layout.recyclerview_footer, parent, false);
                vh = new FooterViewHolder(view);
                return vh;
            case TYPE_MULTI_IMAGES:
                view = mLayoutInflater.inflate(R.layout.item_article_multi_images, parent, false);
                vh = new MultiImagesViewHolder(view);
                return vh;
            case TYPE_ROTATION:
                view = mLayoutInflater.inflate(R.layout.item_article_rotations, parent, false);
                vh = new RotationViewHolder(view);
                return vh;
        }

//        //可以抛出异常，没有对应的View类型
//        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    //返回最底的文章id，为了下拉刷新从该id开始加载
    public int getBottomArticleId() {
        if (articleList == null || articleList.size() == 0) return -1;
        return articleList.get(articleList.size() - 1).getId();
    }

    //返回最底的文章id，为了下拉刷新从该id开始加载
    public int getTopOriginArticleId() {
        if (articleList == null || articleList.size() == 0) return -1;
        return articleList.get(Constant.COUNT_ROTATION).getId();
    }


    /**
     * 当Item 超出屏幕后，就会重新执行onBindViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        //这时候 article是 null，先把 footer 处理了
        if (holder instanceof FooterViewHolder) {
            return;
        }

        //注意RecyclerView第0项是 ViewPager 占据了0 1 2 3 4 5 6 7图片
        //那么下面的列表展示是 RecyclerView 的第1项，从第7项开始
        SimpleArticleItem article = articleList.get(position + Constant.COUNT_ROTATION - 1);
        String[] imageUrls = article.getImageUrls();

        if (holder instanceof ItemArticleViewHolder) {

            //转型
            ItemArticleViewHolder newHolder = (ItemArticleViewHolder) holder;

            if (imageUrls.length == 0) {

            } else {

            }
            newHolder.rcvArticleTitle.setText(article.getTitle());
            newHolder.rcvArticleDate.setText(article.getPublishDate());
            //注意这个阅读次数是 int 类型，需要转化为 String 类型
            newHolder.rcvArticleReadtimes.setText(article.getReadTimes() + "阅");
            newHolder.rcvArticleSummary.setText(article.getSummary());

            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemClick(pos);
                    }
                });
            }

        } else if (holder instanceof MultiImagesViewHolder) {
            MultiImagesViewHolder newHolder = (MultiImagesViewHolder) holder;
            newHolder.articleTitle.setText(article.getTitle());
            newHolder.countPics.setText("图片: " + imageUrls.length);
            newHolder.countRead.setText("浏览: " + article.getReadTimes());

            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemClick(pos);
                    }
                });
            }

        } else if (holder instanceof RotationViewHolder) {


            RotationViewHolder newHolder = (RotationViewHolder) holder;

            List<SimpleArticleItem> headers = articleList.subList(0, Constant.COUNT_ROTATION);
            newHolder.tvCollegeBroadcast.setText("今天是第19周 农历十一月二十 天气晴转多云 气温偏低 请注意防寒");
            setUpViewPager(newHolder.vpHottest, newHolder.llHottestIndicator, headers);
        }
    }

    /**
     * @param vp             轮播图片
     * @param llBottom       底部的小圆点
     * @param headerArticles 新闻，包括了图片url、标题等属性
     */
    private void setUpViewPager(final ViewPager vp, LinearLayout llBottom, final List<SimpleArticleItem> headerArticles) {
        //??这儿有些疑惑，Adapter 里面嵌套设置 Adapter 是否优雅？

//        final Handler mHandler = new Handler() {
//            public void handleMessage(Message msg) {
//                switch (msg.what) {
//                    case UPTATE_VIEWPAGER:
//                        if (msg.arg1 != 0) {
//                            vp.setCurrentItem(msg.arg1);
//                        } else {
//                            //false 当从末页调到首页是，不显示翻页动画效果，
//                            vp.setCurrentItem(msg.arg1, false);
//                        }
//                        break;
//                }
//            }
//        };

        //下面是设置动画切换的样式

        //创建底部指示位置的导航栏
        final ImageView[] mCircleImages = new ImageView[headerArticles.size()];

        //先去除已有的View，所有的小圆点

        llBottom.removeAllViews();

        for (int i = 0; i < mCircleImages.length; i++) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);


            mCircleImages[i] = imageView;
            //把指示作用的原点图片加入底部的视图中
            llBottom.addView(mCircleImages[i]);

        }

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //图片左右滑动时候，将当前页的圆点图片设为选中状态
            @Override
            public void onPageSelected(int position) {
                // 一定几个图片，几个圆点，但注意是从0开始的
                int total = mCircleImages.length;


                //设置全局变量，currentIndex为选中图标的 index
                currentIndex = position;
            }

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                //实现切换到末尾后返回到第一张
                switch (state) {
                    // 手势滑动
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        break;

                    // 界面切换中
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;

                    case ViewPager.SCROLL_STATE_IDLE:// 滑动结束，即切换完毕或者加载完毕
                        // 当前为最后一张，此时从右向左滑，则切换到第一张
                        if (vp.getCurrentItem() == vp.getAdapter().getCount() - 1) {
                            vp.setCurrentItem(0, false);
                        }
                        // 当前为第一张，此时从左向右滑，则切换到最后一张
                        else if (vp.getCurrentItem() == 0) {
                            vp.setCurrentItem(vp.getAdapter().getCount() - 1, false);
                        }
                        break;

                    default:
                        break;
                }
            }
        });


//        //设置自动轮播图片，5s后执行，周期是5s
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Message message = new Message();
//                message.what = UPTATE_VIEWPAGER;
//                if (currentIndex == headerArticles.size() - 1) {
//                    currentIndex = -1;
//                }
//                message.arg1 = currentIndex + 1;
//                mHandler.sendMessage(message);
//            }
//        }, 6000, 6000);
    }

    @Override
    public int getItemCount() {
        //因为多了一个头部，所以是+1,但是头部 ViewPager 占了7个
        //所以实际是少了6个
        if (articleList != null) {
            return articleList.size() + 1 - Constant.COUNT_ROTATION;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return TYPE_ROTATION;
        else {
            SimpleArticleItem article = articleList.get(position + Constant.COUNT_ROTATION - 1);
            if (article == null) {
                return TYPE_FOOTER;
            } else if (article.getImageUrls().length >= 3) {
                return TYPE_MULTI_IMAGES;
            } else {
                return TYPE_NORMAL;
            }
        }
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    class RotationViewHolder extends RecyclerView.ViewHolder {

        //轮播的最热新闻图片
        ViewPager vpHottest;
        //轮播图片下面的小圆点
        LinearLayout llHottestIndicator;

        //学院广播信息
        TextView tvCollegeBroadcast;

        public RotationViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ItemArticleViewHolder extends RecyclerView.ViewHolder {

        TextView rcvArticleTitle;
        TextView rcvArticleDate;
        TextView rcvArticleReadtimes;
        TextView rcvArticleSummary;

        public ItemArticleViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 大于3 张图片使用的ViewHolder
     */
    class MultiImagesViewHolder extends RecyclerView.ViewHolder {


        TextView articleTitle;
        TextView countPics;
        TextView countRead;

        public MultiImagesViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 底部加载更多
     */
    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


}

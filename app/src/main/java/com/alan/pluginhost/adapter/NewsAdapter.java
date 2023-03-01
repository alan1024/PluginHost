package com.alan.pluginhost.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.news.ImageUrl;
import com.alan.pluginhost.news.News;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends BaseAdapter {
    private List<News> mNewsList;
    private Context mContext;

    private int mode;
    private String keyWords;

    private int mStartPosition;
    private int mStopPosition;
    private int mLastPosition;
    private boolean isFirstScroll;
    private int mScrollposition;

    public void setScrollposition(int scrollposition) {
        mScrollposition = scrollposition;
    }

    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    private boolean isScroll;

    public void setFirstScroll(boolean firstScroll) {
        isFirstScroll = firstScroll;
    }

    public void setLastPosition(int lastPosition) {
        mLastPosition = lastPosition;
    }

    public void setStartPosition(int startPosition) {
        mStartPosition = startPosition;
    }

    public void setStopPosition(int stopPosition) {
        mStopPosition = stopPosition;
    }

    public NewsAdapter(Context context, List<News> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    public NewsAdapter(Context context, List<News> newsList, int mode, String keyWords) {
        mContext = context;
        mNewsList = newsList;
        this.mode = mode;
        this.keyWords = keyWords;
    }


    @Override
    public int getCount() {
        return mNewsList.size() - 1;
    }

    @Override
    public Object getItem(int i) {
        return mNewsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_news_view, null);
            viewHolder = new ViewHolder();
            viewHolder.mTvNewsTitle = (TextView) view.findViewById(R.id.tvNewsTitle);
            viewHolder.mTvAbstract = (TextView) view.findViewById(R.id.tvAbstract);
            viewHolder.mIvImage1 = (ImageView) view.findViewById(R.id.ivImage1);
            viewHolder.mIvImage2 = (ImageView) view.findViewById(R.id.ivImage2);
            viewHolder.mIvImage3 = (ImageView) view.findViewById(R.id.ivImage3);
            viewHolder.mTvSource = (TextView) view.findViewById(R.id.tvSource);
            viewHolder.mTvComments = (TextView) view.findViewById(R.id.tvComments);
            viewHolder.mTvTime = (TextView) view.findViewById(R.id.tvTime);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        News news = mNewsList.get(i);

        if (isScroll) {
            setImage(news, viewHolder, true);
        } else {
            setImage(news, viewHolder, false);
        }
        /*
         * 搜索新闻的关键字标记
         * */
        if (mode == 1) {
            char[] keyWord = keyWords.toCharArray();
            SpannableStringBuilder style = new SpannableStringBuilder(news.getTitle());
            for (int j = 0; j < keyWord.length; j++) {
                int position = news.getTitle().trim().indexOf(keyWord[j]);
                if (position != -1) {
                    style.setSpan(new ForegroundColorSpan(Color.RED), news.getTitle().trim().indexOf(keyWord[j])
                            , news.getTitle().trim().indexOf(keyWord[j]) + 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            }
            viewHolder.mTvNewsTitle.setText(style);
        } else {
            viewHolder.mTvNewsTitle.setText(news.getTitle());
        }
//        Log.e("QuickNews",news.getTitle());
        viewHolder.mTvSource.setText(news.getSource());
        viewHolder.mTvComments.setText(" - " + news.getComment_count() + "评论 - ");
        viewHolder.mTvTime.setText(news.getDatetime());

        return view;
    }

    /*
     * 图片的设置与获取
     * */
    private void setImage(News news, ViewHolder viewHolder, boolean isScrolled) {
        List<ImageUrl> imageUrlList = new ArrayList<>();
        imageUrlList = news.getImage_list();
        if (imageUrlList != null) {
//            Log.d("imageUrlList.size()",imageUrlList.size()+"");
            switch (imageUrlList.size()) {
                case 0:
                    if (news.getLarge_image_url() != null) {
                        viewHolder.mIvImage2.setVisibility(View.GONE);
                        viewHolder.mIvImage3.setVisibility(View.GONE);
                        viewHolder.mIvImage1.setVisibility(View.VISIBLE);
//                        viewHolder.mIvImage1.setVisibility(View.INVISIBLE);
                        if (!isScrolled) {
                        }
                    } else {
                        viewHolder.mIvImage1.setVisibility(View.GONE);
                        viewHolder.mIvImage2.setVisibility(View.GONE);
                        viewHolder.mIvImage3.setVisibility(View.GONE);
                    }
                    break;
                case 1:
                    viewHolder.mIvImage2.setVisibility(View.GONE);
                    viewHolder.mIvImage3.setVisibility(View.GONE);
                    viewHolder.mIvImage1.setVisibility(View.VISIBLE);
//                    viewHolder.mIvImage1.setVisibility(View.INVISIBLE);
                    if (!isScrolled) {
                    }
                    break;
                case 2:
                    viewHolder.mIvImage3.setVisibility(View.GONE);
                    viewHolder.mIvImage1.setVisibility(View.VISIBLE);
                    viewHolder.mIvImage2.setVisibility(View.VISIBLE);
                    if (!isScrolled) {
                    }
                    break;
                case 3:
                    viewHolder.mIvImage1.setVisibility(View.VISIBLE);
                    viewHolder.mIvImage2.setVisibility(View.VISIBLE);
                    viewHolder.mIvImage3.setVisibility(View.VISIBLE);
                    if (!isScrolled) {
                    }
                    break;
                default:
                    viewHolder.mIvImage1.setVisibility(View.GONE);
                    viewHolder.mIvImage2.setVisibility(View.GONE);
                    viewHolder.mIvImage3.setVisibility(View.GONE);
                    break;
            }
        } else {
            viewHolder.mIvImage1.setVisibility(View.GONE);
            viewHolder.mIvImage2.setVisibility(View.GONE);
            viewHolder.mIvImage3.setVisibility(View.GONE);
        }
//        System.out.println("news.getTitle()是"+news.getTitle());
    }


    public void getImage(ImageView imageView, String url) {
    }

    public void getImage(ImageView imageView, ViewHolder viewHolder, String url, String tag) {
//        boolean isTag=false;
        if (viewHolder.mIvImage1.getTag() != null && viewHolder.mIvImage1.getTag().equals(tag)) {

        }
        if (viewHolder.mIvImage2.getTag() != null && viewHolder.mIvImage2.getTag().equals(tag)) {
            imageView = viewHolder.mIvImage2;

        }
        if (viewHolder.mIvImage3.getTag() != null && viewHolder.mIvImage3.getTag().equals(tag)) {
            imageView = viewHolder.mIvImage3;

        }

    }

    public static class ViewHolder {
        private TextView mTvNewsTitle;
        private TextView mTvAbstract;
        private ImageView mIvImage1;
        private ImageView mIvImage2;
        private ImageView mIvImage3;
        private TextView mTvSource;
        private TextView mTvComments;
        private TextView mTvTime;
    }


}

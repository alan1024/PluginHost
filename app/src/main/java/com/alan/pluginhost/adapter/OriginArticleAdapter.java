package com.alan.pluginhost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.model.SimpleArticleItem;
import com.alan.pluginhost.util.OnItemClickLitener;

import java.util.ArrayList;
import java.util.List;


public class OriginArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public final static int TYPE_MULTI_IMAGES = 2; // 多个图片的文章
    public final static int TYPE_FOOTER = 3;//底部--往往是loading_more
    public final static int TYPE_NORMAL = 1; // 正常的一条文章
    //新闻列表
    private List<SimpleArticleItem> articleList;
    //context
    private Context context;

    private LayoutInflater mLayoutInflater;

    private OnItemClickLitener mOnItemClickLitener;//点击 RecyclerView 中的 Item

    public OriginArticleAdapter(Context context, List<SimpleArticleItem> articleList) {
        this.context = context;
        if (articleList == null) {
            this.articleList = new ArrayList<SimpleArticleItem>();
        } else {
            this.articleList = articleList;
        }
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 根据不同的类别返回不同的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder vh;
        View view;
        switch (viewType) {
            //其他无法处理的情况使用viewholder_article_simple
            default:
            case TYPE_NORMAL:
                view = mLayoutInflater.inflate(
                        R.layout.item_article_normal, parent, false);
                vh = new ItemArticleViewHolder(view);
                return vh;
            case TYPE_FOOTER:
                view = mLayoutInflater.inflate(
                        R.layout.recyclerview_footer, parent, false);
                vh = new FooterViewHolder(view);
                return vh;
            case TYPE_MULTI_IMAGES:
                view = mLayoutInflater.inflate(
                        R.layout.item_article_multi_images, parent, false);
                vh = new MultiImagesViewHolder(view);
                return vh;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        SimpleArticleItem article = articleList.get(position);
        String[] imageUrls = article.getImageUrls();

        if (holder instanceof ItemArticleViewHolder) {
            ItemArticleViewHolder newHolder = (ItemArticleViewHolder) holder;
            newHolder.rcvArticleTitle.setText(article.getTitle());
            newHolder.rcvArticleDate.setText(article.getPublishDate());

            //注意这个阅读次数是 int 类型，需要转化为 String 类型
            newHolder.rcvArticleReadtimes.setText("浏览: " + article.getReadTimes());

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
        } else {
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
        }

    }


    /**
     * 传进来的 List 末尾增加一个 null
     * null 作为是上拉的 progressBar 的标记
     * http://android-pratap.blogspot.com/2015/06/endless-recyclerview-with-progress-bar.html
     * 参看的这篇文章
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        SimpleArticleItem article = articleList.get(position);
        if (article == null) {
            return TYPE_FOOTER;
        } else if (article.getImageUrls().length >= 3) {
            return TYPE_MULTI_IMAGES;
        } else {
            return TYPE_NORMAL;
        }

    }

    @Override
    public int getItemCount() {
        if (articleList != null) {
            return articleList.size();
        } else {
            return 0;
        }
    }


    public int getBottomArticleId() {
        if (articleList == null || articleList.size() == 0)
            return -1;
        return articleList.get(articleList.size() - 1).getId();
    }

    //返回最底的文章id，为了下拉刷新从该id开始加载
    public int getTopArticleId() {
        if (articleList == null || articleList.size() == 0)
            return -1;
        return articleList.get(0).getId();
    }


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
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

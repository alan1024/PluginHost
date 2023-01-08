package com.alan.pluginhost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.model.ReviewedArticle;
import com.alan.pluginhost.util.OnDeleteClickLitener;
import com.alan.pluginhost.util.OnItemClickLitener;
import com.alan.pluginhost.util.OnItemLongClickLitener;

import java.util.ArrayList;
import java.util.List;

public class HistoryArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    //新闻列表
    private List<ReviewedArticle> articleList;
    //context
    private Context context;

    private LayoutInflater mLayoutInflater;

    private OnItemClickLitener mOnItemClickLitener;//点击 RecyclerView 中的 Item
    private OnItemLongClickLitener mOnItemLongClickLitener;//点击 RecyclerView 中的 Item
    private OnDeleteClickLitener mOnDeleteClickLitener;//点击 RecyclerView 中的 Item

    public HistoryArticleAdapter(Context context, List<ReviewedArticle> articleList) {
        this.context = context;
        if (articleList == null) {
            this.articleList = new ArrayList<ReviewedArticle>();
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

        View view = mLayoutInflater.inflate(R.layout.item_article_history, parent, false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        ReviewedArticle article = articleList.get(position);

        HistoryViewHolder newHolder = (HistoryViewHolder) holder;


    }


    @Override
    public int getItemCount() {

        if (articleList != null) {
            return articleList.size();
        } else {
            return 0;
        }
    }


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public void setOnItemLongClickLitener(OnItemLongClickLitener mOnItemLongClickLitener) {
        this.mOnItemLongClickLitener = mOnItemLongClickLitener;
    }

    public void setOnDeleteClickLitener(OnDeleteClickLitener mOnDeleteClickLitener) {
        this.mOnDeleteClickLitener = mOnDeleteClickLitener;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {


        TextView rcvArticleTitle;
        TextView rcvClickTime;

        public HistoryViewHolder(View itemView) {
            super(itemView);

        }
    }

}

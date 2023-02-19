package com.alan.pluginhost.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.beans.QuestionTable;
import com.alan.pluginhost.beans.ReplyTable;
import com.alan.pluginhost.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;


public class QuestionAdapter<T> extends RecyclerView.Adapter<QuestionAdapter<T>.MyViewHolder> {
  private LayoutInflater mInflater;
  private Context mContext;
  private List<T> mTable = new ArrayList<>();
  private MyViewHolder mHolder;
  public static final String TAG = "RECYCLERTEXT";

  public QuestionAdapter(Context context) {
    mContext = context;
    this.mInflater = LayoutInflater.from(context);
  }


  public QuestionAdapter(Context context, List<T> list) {
    this(context);
    mTable = list;
  }

  public void setDataSets(List<T> list) {
    LogUtils.d(TAG, "setDataSets and list size = " + list.size());
    mTable.clear();
    mTable.addAll(list);
    notifyDataSetChanged();
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    LogUtils.d(TAG, "onBindViewHolder() and position = " + position);
    T table = mTable.get(position);
    if (table instanceof QuestionTable) {
      final QuestionTable questionTable = (QuestionTable) table;
      handleQuestion(questionTable, holder, position);
    } else if (table instanceof ReplyTable) {
      ReplyTable replyTable = (ReplyTable) table;
      handleAnswer(replyTable, holder, position);
    }
  }

  private void handleQuestion(final QuestionTable questionTable, MyViewHolder holder, int position) {
    holder.contentTV.setText(questionTable.getQuestion_content());
//    holder.answerBT.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(CommentAddFragment.EXTRA_USERBEAN, questionTable.getNewsId());
//        bundle.putSerializable(CommentAddFragment.EXTRA_QUESTIONTABLE, questionTable);
//        CommentAddFragment fragment = new CommentAddFragment();
//        fragment.setArguments(bundle);
//        if (mContext instanceof AppCompatActivity) {
//          AppCompatActivity activity = (AppCompatActivity) mContext;
//          FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
//          transaction.replace(R.id.frame_comment_content, fragment);
//          transaction.commit();
//        }
//      }
//    });
//    holder.cardView.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(CommentAddFragment.EXTRA_USERBEAN, questionTable.getNewsId());
//        bundle.putSerializable(CommentAddFragment.EXTRA_QUESTIONTABLE, questionTable);
//        CommentToQuestionFragment fragment = new CommentToQuestionFragment();
//        fragment.setArguments(bundle);
//        if (mContext instanceof AppCompatActivity) {
//          AppCompatActivity activity = (AppCompatActivity) mContext;
//          FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
//          transaction.replace(R.id.frame_comment_content, fragment);
//          transaction.commit();
//        }
//      }
//    });
  }

  private void handleAnswer(final ReplyTable replyTable, MyViewHolder holder, int position) {
//    holder.nameTV.setText(replyTable.getReplyerId().getUsername());
//    holder.contentTV.setText(replyTable.getReply_content());
//    holder.answerBT.setText("更多");
//    holder.answerBT.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(DetailFragment.DETAIL_CONTENT, replyTable);
//        DetailFragment fragment = new DetailFragment();
//        fragment.setArguments(bundle);
//        if (mContext instanceof AppCompatActivity) {
//          AppCompatActivity activity = (AppCompatActivity) mContext;
//          FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
//          transaction.replace(R.id.frame_comment_content, fragment);
//          transaction.commit();
//        }
//      }
//    });
  }

  @Override
  public int getItemCount() {
    if (mTable == null)
      return 0;
    LogUtils.d(TAG, "getItemCount() and item count = " + mTable.size());
    return mTable.size();
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//    View view = mInflater.inflate(R.layout.item_comment_main,parent,false);
    mHolder = new MyViewHolder(null);
    return mHolder;
  }


  public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTV;
    private TextView contentTV;
    private CardView cardView;

    public MyViewHolder(View view) {
      super(view);
    }
  }
}

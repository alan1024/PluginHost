package com.alan.pluginhost.modules.douban;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.pluginhost.R;
import com.alan.pluginhost.magicrecyclerView.BaseItem;
import com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter;
import com.alan.pluginhost.modules.douban.mvp.MovieSubject;


public class MovieListAdapter extends BaseRecyclerAdapter {

    private Fragment mFragment;

    public MovieListAdapter(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, BaseItem data) {
        MovieSubject movieSubject = (MovieSubject) data.getData();
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.mMovieName.setText(movieSubject.getTitle());
        float rate = movieSubject.getRating().getAverage();
        holder.mMovieRate.setText(toString(rate));
        holder.mMovieStarts.setRating(rate / 2);
        String image = movieSubject.getImages().getMedium();
        if (!TextUtils.isEmpty(image)) {
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mMoviePic;
        TextView mMovieName;
        RatingBar mMovieStarts;
        TextView mMovieRate;

        ViewHolder(View view) {
            super(view);
        }
    }

    private String toString(Object string) {
        return string + "";
    }

}

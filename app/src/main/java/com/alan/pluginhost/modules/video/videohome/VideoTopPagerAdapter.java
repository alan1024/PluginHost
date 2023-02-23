package com.alan.pluginhost.modules.video.videohome;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.alan.pluginhost.R;
import com.alan.pluginhost.modules.video.videohome.mvp.RetDataBean;

import java.util.List;


public class VideoTopPagerAdapter extends PagerAdapter {

    private List<RetDataBean.ListBean.ChildListBean> mBanders;
    private Context mContext;
    private Activity mActivity;

    public VideoTopPagerAdapter(Fragment fragment, List<RetDataBean.ListBean.ChildListBean> banders) {
        mContext = fragment.getContext();
        mActivity = fragment.getActivity();
        mBanders = banders;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_main, container, false);
        String image = mBanders.get(position).getPic();
        if (!TextUtils.isEmpty(image)) {
        }
//        mTopStoryImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到其他界面
//                Bundle bundle = new Bundle();
//                Intent intent = new Intent(mContext, VideoInfoActivity.class);
//                bundle.putString(Constants.BUNDLE_KEY_ID, mBanders.get(position).getDataId());
//                bundle.putString(Constants.BUNDLE_KEY_TITLE, mBanders.get(position).getTitle());
//                bundle.putString(Constants.BUNDLE_KEY_IMG_URL, mBanders.get(position).getPic());
//                intent.putExtras(bundle);
////                //多个控件共享用pairs
////                Pair[] pairs = TranslateHelper.createSafeTransitionParticipants(mFragment.getActivity(), false,
////                        new Pair<>(mTopStoryImg, mFragment.getString(R.string.zhihu_story_img)));
////                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(mFragment.getActivity(), pairs);
//                mContext.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(mActivity).toBundle());
//            }
//        });
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return mBanders != null ? mBanders.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        notifyDataSetChanged();
    }

    public void resetData(List<RetDataBean.ListBean.ChildListBean> banders) {
        mBanders.clear();
        mBanders.addAll(banders);
        notifyDataSetChanged();
    }
}

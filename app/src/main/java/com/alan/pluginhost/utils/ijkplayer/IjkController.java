package com.alan.pluginhost.utils.ijkplayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alan.pluginhost.utils.ijkplayer.widget.media.IjkVideoView;
import com.alan.pluginhost.utils.ijkplayer.widget.view.ProgressView;


public class IjkController {

    public static final int PLAY_PROGRESS = 0;
    public static final int SHOW = 1;
    public static final int HIDE_DELAY = 2;

    private final Activity mContext;
    private View mView;
    private View mAnchor;
    private PopupWindow mPopupWindow;
    private LinearLayout mLlTopBar;
    private ImageView mIvBack;
    private TextView mTvTitle;
    //    private TextView mTvDecode;
    //    private ImageView mIvTrack;
    private LinearLayout mLlBottomBar;
    private ImageView mIvClock;
    private ImageView mIvPrevious;
    private ImageView mIvPlay;
    private ImageView mIvNext;
    private ImageView mIvRatio;
    private TextView mTvCurrentTime;
    private ProgressView mPvPlay;
    private TextView mTvTotalTime;
    private ImageView mIvRotate;
    private ProgressView mPvBrightnessVolume;
    private LinearLayout mLlBrightnessVolume;
    private ImageView mIvBrightnessVolume;
    private TextView mTvBrightnessVolume;
    private ImageView mIvLockOutside;

    private MediaController.MediaPlayerControl mPlayer;


    private boolean mIsLock;

    private IjkVideoView mIjkVideoView;

    private boolean mAnimationStart;

    private AudioManager mAudioManager;
    private boolean mActionDown;
    private boolean mActionMove;


    private float mStartY;
    private float mLastY;

    private WindowManager.LayoutParams mParams;
    private int mTouchSlop;

    private float mBrightness = -1;

    public IjkController(Activity context, String name) {
        mContext = context;

        initPopupWindow(name);


    }

    private void initPopupWindow(String name) {


    }

    public int getScreenBrightness(Activity activity) {
        int value = 0;
        ContentResolver cr = activity.getContentResolver();
        try {
            value = Settings.System.getInt(cr, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {

        }
        return value;
    }

}

package com.alan.pluginhost;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class PicassoTarget {
    private static final float SCRIM_ADJUSTMENT = 0.075f;
    private Activity mActivity;
    private ImageView mImageView;
    private CollapsingToolbarLayout mToolbarLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mFloatingActionButton;
    private LoadListener mListener;

    public PicassoTarget(Activity activity, ImageView imageView, Toolbar toolbar) {
        this(activity, imageView, null, toolbar, null);
    }

    public PicassoTarget(Activity activity, ImageView imageView, Toolbar toolbar, LoadListener listener) {
        this(activity, imageView, null, toolbar, null);
        this.mListener = listener;
    }

    public PicassoTarget(Activity activity, ImageView imageView, CollapsingToolbarLayout toolbarLayout, Toolbar toolbar, FloatingActionButton fab) {
        mActivity = activity;
        mImageView = imageView;
        mToolbarLayout = toolbarLayout;
        mToolbar = toolbar;
        mFloatingActionButton = fab;
    }

    public void onBitmapLoaded(final Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
        final int twentyFourDip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                24, mActivity.getResources().getDisplayMetrics());
        assert bitmap != null;
//        Palette.from(bitmap)
//                .maximumColorCount(16)
//                .clearFilters()
//                .setRegion(0, 0, bitmap.getWidth() - 1, twentyFourDip)
//                .generate(new Palette.PaletteAsyncListener() {
//                    @TargetApi(Build.VERSION_CODES.M)
//                    @Override
//                    public void onGenerated(Palette palette) {
//                        boolean isDark;
//                        int lightness = ColorUtils.isDark(palette);
//                        if (lightness == ColorUtils.LIGHTNESS_UNKNOWN) {
//                            isDark = ColorUtils.isDark(bitmap, bitmap.getWidth() / 2, 0);
//                        } else {
//                            isDark = lightness == ColorUtils.IS_DARK;
//                        }
//                        // color the status bar. Set a complementary dark color on L,
//                        // light or dark color on M (with matching status bar icons)
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            int statusBarColor = mActivity.getWindow().getStatusBarColor();
//                            final Palette.Swatch topColor = ColorUtils.getMostPopulousSwatch(palette);
//                            if (topColor != null && (isDark || Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
//                                statusBarColor = ColorUtils.scrimify(topColor.getRgb(), isDark, SCRIM_ADJUSTMENT);
//                                // set a light status bar on M+
//                                if (!isDark && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                    ViewUtils.setLightStatusBar(mImageView);
//                                }
//                            }
//                            if (statusBarColor != mActivity.getWindow().getStatusBarColor()) {
//                                ValueAnimator statusBarColorAnim = ValueAnimator.ofArgb(
//                                        mActivity.getWindow().getStatusBarColor(), statusBarColor);
//                                statusBarColorAnim.addUpdateListener(new ValueAnimator
//                                        .AnimatorUpdateListener() {
//                                    @Override
//                                    public void onAnimationUpdate(ValueAnimator animation) {
//                                        mActivity.getWindow().setStatusBarColor((int) animation.getAnimatedValue());
//                                        BaseActivity.currentStatusColor = (int) animation.getAnimatedValue();
//                                    }
//                                });
//                                statusBarColorAnim.setDuration(500L);
//                                statusBarColorAnim.setInterpolator(
//                                        new AccelerateInterpolator());
//                                statusBarColorAnim.start();
//                                if (ColorUtils.compareColors(Color.WHITE, statusBarColor) > 0.8) {
//                                    statusBarColor = ColorUtils.blendColors(statusBarColor, mActivity.getResources().getColor(R.color.black_000000), 0.2f);
//                                }
//                                if (mToolbarLayout != null) {
//                                    mToolbarLayout.setContentScrimColor(statusBarColor);
//                                    mToolbar.setBackgroundColor(ColorUtils.modifyAlpha(statusBarColor, 0.5f));
//                                } else { //无toolbarlayout时保持toolbar颜色与状态栏一致
//                                    mToolbar.setBackgroundColor(ColorUtils.modifyAlpha(statusBarColor, 0.8f));
//                                }
//                                if (mFloatingActionButton != null) {
//                                    mFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(statusBarColor));
//                                }
//                            }
//                        }
//                    }
//                });
        if (mListener != null) {
            mListener.loaded(bitmap);
        }
    }

    public void onBitmapFailed(Drawable errorDrawable) {

    }

    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }

    public interface LoadListener {
        void loaded(Bitmap bitmap);
    }

}


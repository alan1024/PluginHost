package com.alan.pluginhost.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

public class MyEmptyViewHeader extends LinearLayout {
	private LinearLayout mContainer;
	private int mState = STATE_NORMAL;

	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_REFRESHING = 2;

	public MyEmptyViewHeader(Context context) {
		super(context);
		initView(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public MyEmptyViewHeader(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {
		// 初始情况，设置下拉刷新view高度为0
		LayoutParams lp = new LayoutParams(
				LayoutParams.FILL_PARENT, 0);
		lp.gravity = Gravity.CENTER;
		mContainer = new LinearLayout(context);
		addView(mContainer, lp);
		setGravity(Gravity.BOTTOM);
	}

	public void setState(int state) {
		if (state == mState) return;
		mState = state;
	}

	public void setVisiableHeight(int height) {
		if (height < 0)
			height = 0;
		LayoutParams lp = (LayoutParams) mContainer
				.getLayoutParams();
		lp.height = height;
		mContainer.setLayoutParams(lp);
	}

	public int getVisiableHeight() {
		return mContainer.getHeight();
	}

	/**
	 * hide footer when disable pull load more
	 */
	public void hide() {
		mState = STATE_NORMAL;
		LayoutParams lp = (LayoutParams) mContainer.getLayoutParams();
		lp.height = 0;
		mContainer.setLayoutParams(lp);
		mContainer.removeAllViews();
	}

	/**
	 * show footer
	 */
	public void show(View view) {
		if (mState == STATE_REFRESHING) {
			return;
		}
		mState = STATE_REFRESHING;
		LayoutParams lp = (LayoutParams) mContainer.getLayoutParams();
		lp.height = LayoutParams.WRAP_CONTENT;
		mContainer.removeView(view);
		mContainer.addView(view, lp);
	}

}

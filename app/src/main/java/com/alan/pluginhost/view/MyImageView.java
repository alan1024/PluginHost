package com.alan.pluginhost.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.widget.AppCompatImageView;

import com.alan.pluginhost.R;


public class MyImageView extends AppCompatImageView implements OnClickListener {

	private Drawable mDefaultAvatar;

	private boolean markEnable = true;

	public MyImageView(Context context) {
		this(context, null);
	}

	public MyImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setOnClickListener(this);
		setScaleType(ScaleType.FIT_CENTER);
		setBackgroundResource(R.drawable.ic_launcher_background);
	}

	/**
	 * Resets the contact photo to the default state.
	 */
	public void setImageToDefault() {
		if (mDefaultAvatar == null) {
			mDefaultAvatar = getResources().getDrawable(R.drawable.ic_launcher_background);
		}
		setImageDrawable(mDefaultAvatar);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public boolean isMarkEnable() {
		return markEnable;
	}

	public void setMarkEnable(boolean markEnable) {
		this.markEnable = markEnable;
	}

}

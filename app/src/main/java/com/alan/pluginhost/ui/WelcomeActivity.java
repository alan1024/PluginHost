package com.alan.pluginhost.ui;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.alan.pluginhost.MainActivity;
import com.alan.pluginhost.R;
import com.alan.pluginhost.ui.base.BaseActivity;
import com.alan.pluginhost.widget.CustomVideoView;

public class WelcomeActivity extends BaseActivity {
    private Button welcome_button;
    private CustomVideoView welcome_videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);
        welcome_button = (Button) this.findViewById(R.id.welcome_button);

        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (welcome_videoview.isPlaying()) {
                    welcome_videoview.stopPlayback();
                    welcome_videoview = null;
                }
                openActivity(MainActivity.class);
                WelcomeActivity.this.finish();
            }
        });
    }

    private String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

}

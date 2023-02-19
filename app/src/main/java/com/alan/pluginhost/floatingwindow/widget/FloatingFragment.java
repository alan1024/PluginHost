package com.alan.pluginhost.floatingwindow.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


/**
 * Created by SomeOneInTheWorld on 2016/7/1.
 */
public class FloatingFragment extends Fragment {

    private NewsTagService mService;
    private Intent mServiceIntent;
    private ServiceConnection mConnection;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        bindService();
//
//        FancyButton fb = (FancyButton) view.findViewById(R.id.bt_switch2floatingwindow);
//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mContext.startService(mServiceIntent);
//                if(mService != null){
//                    mService.show();
//                }
//            }
//        });
        return null;
    }

    private void bindService() {
        mServiceIntent = new Intent(mContext, NewsTagService.class);
        if (mConnection == null) {
            mConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    mService = ((NewsTagService.FloatingNewsBinder) service).getService();
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            };

            mContext.bindService(mServiceIntent, mConnection, mContext.BIND_AUTO_CREATE);
        }
    }

    private void unbindService() {
        if (null != mConnection) {
            mContext.unbindService(mConnection);
            mConnection = null;
        }
    }

    @Override
    public void onDestroy() {
        unbindService();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        unbindService();
        super.onPause();
    }

    @Override
    public void onStop() {
        unbindService();
        super.onStop();
    }

    @Override
    public void onResume() {
        bindService();
        super.onResume();
    }
}

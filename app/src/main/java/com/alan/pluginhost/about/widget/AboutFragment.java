package com.alan.pluginhost.about.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;


public class AboutFragment extends Fragment {
    //        implements BluetoothHelper.BluetoothCallback{
//    private BluetoothHelper mBluetoothHelper;
    private ProgressBar mProgressBar;


//    @Override
//    public void beginToDiscover() {
//        mProgressBar.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void finishDiscover(List<?> result) {
//        mProgressBar.setVisibility(View.GONE);
//        mBluetoothHelper.connectToDevice(result.size()-1);
//    }
//
//    @Override
//    public void read(String message) {
//
//    }
//
//    @Override
//    public void write(String message) {
//
//    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_about, null);
//        Button button = (Button)view.findViewById(R.id.server_bt);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mBluetoothHelper.sendMessage("this is successful");
//            }
//        });
//        mProgressBar = (ProgressBar)view.findViewById(R.id.progress_wait);
//        mBluetoothHelper = new BluetoothHelper(getContext(),this);
//        return view;

        View view = null;

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
//        mBluetoothHelper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mBluetoothHelper.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mBluetoothHelper.onActivityResult(requestCode,resultCode,data);
    }
}

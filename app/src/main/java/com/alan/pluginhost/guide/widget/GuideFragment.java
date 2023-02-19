package com.alan.pluginhost.guide.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alan.pluginhost.MainActivity;
import com.alan.pluginhost.guide.presenter.GuidePresenter;
import com.alan.pluginhost.guide.presenter.GuidePresenterImpl;
import com.alan.pluginhost.guide.view.GuideView;


public class GuideFragment extends Fragment implements GuideView {

    private GuidePresenter mPresenter;

    private EditText mUserNameET;
    private EditText mUserPasswordET;
    private ProgressBar mProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GuidePresenterImpl(this, getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        final View view = inflater.inflate(R.layout.fragment_guide,container,false);
//        initViews(view);

//        mLoginBT.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                UserBean user = new UserBean();
//                String userName = mUserNameET.getText().toString();
//                String password = mUserPasswordET.getText().toString();
//                user.setUsername(userName);
//                user.setPassword(password);
//                mPresenter.loadUserIfExist(user);
//            }
//        });
//
//        mRegisterBT.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                registerNewUser();
//            }
//        });

        return null;
    }

    private void initViews(View view) {
//        mUserNameET = (EditText)view.findViewById(R.id.et_username);
//        mUserPasswordET = (EditText)view.findViewById(R.id.et_password);
//        mProgressBar = (ProgressBar)view.findViewById(R.id.progress_guide);
    }

    @Override
    public void showProgressbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void registerNewUser() {
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.frame_content,new RegisterFragment()).commit();
    }

    @Override
    public void onSuccessFound() {
        Intent view = new Intent(getActivity(), MainActivity.class);
        view.setAction(Intent.ACTION_VIEW);
        startActivity(view);
        getActivity().finish();
    }

    @Override
    public void onFailureFound(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

package com.tfg.dani.tfg.features.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.tfg.dani.tfg.R;
import com.tfg.dani.tfg.base.BaseView;
import com.tfg.dani.tfg.core.entities.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dani on 21/11/15.
 */
public class LoginView extends BaseView implements InterfaceLoginView {

    private static final String TAG = "LoginView";

    private LoginPresenter mPresenter;

    public static LoginView newInstance() {
        LoginView fragment = new LoginView();
        return fragment;
    }

    @Override
    public MvpPresenter createPresenter() {
        mPresenter = LoginPresenter.getInstance();
        return mPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onUserReceived(User user) {
        Log.v(TAG, user.getmEmail());
    }

    @OnClick(R.id.login_button)
    public void onLoginButtonClicked() {
        Log.e(TAG, "mPresenter->loginUser");
        mPresenter.loginUser("dani@dani", "token");
    }

}

package com.tfg.dani.tfg.features.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.tfg.dani.tfg.R;
import com.tfg.dani.tfg.base.BaseView;
import com.tfg.dani.tfg.core.entities.User;

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

    @OnClick(R.id.sign_in_button)
    public void onGoogleSignInButtonClicked() {
        mPresenter.signInWithGoogle();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == LoginPresenter.RC_SIGN_IN) {
            mPresenter.handleGoogleSignInResult(data);
        }
    }
}

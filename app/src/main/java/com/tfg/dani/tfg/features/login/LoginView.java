package com.tfg.dani.tfg.features.login;

import com.google.android.gms.common.SignInButton;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.tfg.dani.tfg.R;
import com.tfg.dani.tfg.base.BaseView;
import com.tfg.dani.tfg.base.BaseViewInterface;
import com.tfg.dani.tfg.core.entities.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dani on 21/11/15.
 */
public class LoginView extends BaseView implements InterfaceLoginView {

    private static final String TAG = "LoginView";

    @Bind(R.id.sign_in_button)
    SignInButton mSignInButton;

    private LoginPresenter mPresenter;

    public static LoginView newInstance() {
        LoginView fragment = new LoginView();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = LoginPresenter.getInstance(this);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSignInButton.setSize(SignInButton.SIZE_WIDE);
        mSignInButton.setScopes(mPresenter.getGoogleSignInOptions().getScopeArray());
    }

    @Override
    public void onStart() {
        super.onStart();
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

package com.tfg.dani.tfg.features.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

import nucleus.view.NucleusFragment;

/**
 * Created by dani on 31/10/15.
 */
public class LoginView extends MvpFragment<LoginView, LoginPresenter> {

    public static LoginView getInstance() {
        return new LoginView();
    }

    public LoginView(){}

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

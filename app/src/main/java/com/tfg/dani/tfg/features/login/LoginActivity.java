package com.tfg.dani.tfg.features.login;

import android.app.Activity;
import android.os.Bundle;

import com.tfg.dani.tfg.R;
import com.tfg.dani.tfg.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadFragment(LoginView.getInstance());
    }

}

package com.tfg.dani.tfg.features.login;

import android.content.Intent;
import android.os.Bundle;

import com.tfg.dani.tfg.base.BaseActivity;

/**
 * Created by dani on 21/11/15.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadFragment(LoginView.newInstance());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

package com.tfg.dani.tfg.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.tfg.dani.tfg.R;

import butterknife.ButterKnife;


/**
 * Created by dani on 31/10/15.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        setContentView(R.layout.activity_base);
    }

    public void loadFragment(Fragment fragment) {
        loadFragment(fragment, null);
    }

    public void loadFragment(Fragment fragment, String addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        /**
         * isFinishing() prevents to load a Fragment,
         * when the activity is going to be killed or destroyed!
         */
        if (fragmentManager == null || isFinishing()) { // solving a bug when quickly get back from any fragment
            return;
        }

            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(addToBackStack).commitAllowingStateLoss();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

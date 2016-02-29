package com.tfg.dani.tfg.features.utils;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/**
 * Created by flamingo on 29/2/16.
 */
public class GoogleSignInUtils {

    private static GoogleSignInUtils mInstance;
    private static GoogleApiClient.OnConnectionFailedListener mListener;
    private GoogleApiClient mGoogleApiClient;

    private FragmentActivity mContext;

    public static GoogleSignInUtils getInstance(FragmentActivity context, GoogleApiClient.OnConnectionFailedListener listener) {
        if(mInstance == null) {
            mInstance = new GoogleSignInUtils(context, listener);
        }

        return mInstance;
    }

    public GoogleSignInUtils(FragmentActivity context, GoogleApiClient.OnConnectionFailedListener listener) {
        this.mContext = context;
        this.mListener = listener;

        setUpGoogleSignIn();
    }

    private void setUpGoogleSignIn() {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .enableAutoManage(mContext, mListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    public Intent getGoogleSignInIntent() {
        return Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
    }

    public GoogleSignInAccount getSignInResultAccount(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        if (result.isSuccess()) {
            return result.getSignInAccount();
        } else {
            return null;
        }
    }
}

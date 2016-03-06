package com.tfg.dani.tfg.features.login;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import com.tfg.dani.tfg.R;
import com.tfg.dani.tfg.core.base.BasePresenter;
import com.tfg.dani.tfg.core.base.BaseViewInterface;
import com.tfg.dani.tfg.core.services.ServiceBuilder;
import com.tfg.dani.tfg.core.services.restservices.UserService;
import com.tfg.dani.tfg.features.utils.GoogleSignInUtils;

import android.content.Intent;
import android.util.Log;

/**
 * Created by dani on 21/11/15.
 */
public class LoginPresenter extends BasePresenter<LoginView> implements
        GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "LoginView";
    public static final int RC_SIGN_IN = 9001;

    private static LoginPresenter mInstance;
    private GoogleSignInUtils mGoogleSignInUtils;

    private UserService mService;

    public static LoginPresenter getInstance(LoginView view) {
        mInstance = new LoginPresenter(view);
        return mInstance;
    }

    public LoginPresenter(LoginView view) {
        setView(view);
        mService = ServiceBuilder.createService(UserService.class);
        mGoogleSignInUtils = GoogleSignInUtils.getInstance(getView().getActivity(), this);
    }

    public void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInUtils.getGoogleSignInIntent();
        getView().startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void handleGoogleSignInResult(Intent data) {
        GoogleSignInAccount account = mGoogleSignInUtils.getSignInResultAccount(data);

        if (account == null) {
            getView().showSnackbar(getView().getString(R.string.error_autentication),
                    BaseViewInterface.TypeSnackbar.TYPE_ERROR);
        } else {
            //TODO: abrir main activity
        }
    }

    @Override
    public void onError(String error) {
        Log.e(TAG, error);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        getView().showSnackbar(connectionResult.getErrorMessage(),
                BaseViewInterface.TypeSnackbar.TYPE_ERROR);
    }

    public GoogleSignInOptions getGoogleSignInOptions() {
        return mGoogleSignInUtils.getGoogleSignInOptions();
    }
}

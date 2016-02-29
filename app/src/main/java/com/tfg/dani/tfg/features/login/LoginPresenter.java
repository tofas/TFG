package com.tfg.dani.tfg.features.login;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.tfg.dani.tfg.base.BasePresenter;
import com.tfg.dani.tfg.core.entities.User;
import com.tfg.dani.tfg.core.services.ServiceBuilder;
import com.tfg.dani.tfg.core.services.restservices.UserService;
import com.tfg.dani.tfg.features.utils.GoogleSignInUtils;

import android.content.Intent;
import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dani on 21/11/15.
 */
public class LoginPresenter extends BasePresenter<LoginView> implements InterfaceLoginPresenter,
        GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "LoginView";
    public static final int RC_SIGN_IN = 9001;

    private static LoginPresenter mInstance;
    private GoogleSignInUtils mGoogleSignInUtils;

    private UserService mService;

    public static LoginPresenter getInstance() {
        mInstance = new LoginPresenter();
        return mInstance;
    }

    public LoginPresenter() {
        mService = ServiceBuilder.createService(UserService.class);
    }

    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
        mGoogleSignInUtils = GoogleSignInUtils.getInstance(getView().getActivity(), this);
    }

    @Override
    public void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInUtils.getGoogleSignInIntent();
        getView().getActivity().startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void handleGoogleSignInResult(Intent data) {
        GoogleSignInAccount account = mGoogleSignInUtils.getSignInResultAccount(data);

        if(account == null) {
            //TODO: mostrar error de autenticación
        } else {
            //TODO: llamar a servicio de checkeo de usuario
        }
    }

    @Override
    public void onError(String error) {
        Log.e(TAG, error);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        //TODO: mostrar error de conexión con google
    }

    @Override
    public GoogleSignInOptions getGoogleSignInOptions() {
        return mGoogleSignInUtils.getGoogleSignInOptions();
    }
}

package com.tfg.dani.tfg.features.login;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.tfg.dani.tfg.base.BasePresenter;
import com.tfg.dani.tfg.core.entities.User;
import com.tfg.dani.tfg.core.services.ServiceBuilder;
import com.tfg.dani.tfg.core.services.restservices.UserService;

import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dani on 21/11/15.
 */
public class LoginPresenter extends BasePresenter<LoginView> implements InterfaceLoginPresenter {

    private static final String TAG = "LoginView";

    private static LoginPresenter mInstance;

    private UserService mService;

    public static LoginPresenter getInstance() {
        mInstance = new LoginPresenter();
        return mInstance;
    }

    public LoginPresenter() {
        mService = ServiceBuilder.createService(UserService.class);
    }

    @Override
    public void loginUser(String email, String token) {
        mService.login(email, token)
                .onErrorResumeNext(throwable -> Observable.<User>empty())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> onUserReceived(user));
    }

    public void onUserReceived(User user) {
        getView().onUserReceived(user);
    }

    @Override
    public void onError(String error) {
        Log.e(TAG, error);
    }
}

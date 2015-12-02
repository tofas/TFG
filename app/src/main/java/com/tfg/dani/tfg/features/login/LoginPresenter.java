package com.tfg.dani.tfg.features.login;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.tfg.dani.tfg.base.BasePresenter;
import com.tfg.dani.tfg.core.entities.User;
import com.tfg.dani.tfg.core.services.ServiceBuilder;
import com.tfg.dani.tfg.core.services.restservices.UserService;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dani on 21/11/15.
 */
public class LoginPresenter extends MvpBasePresenter<InterfaceLoginView> implements InterfaceLoginPresenter {

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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> onUserReceived(user));
    }

    public void onUserReceived(User user) {
        getView().onUserReceived(user);
    }
}

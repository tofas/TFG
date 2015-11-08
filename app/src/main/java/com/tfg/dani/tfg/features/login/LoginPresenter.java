package com.tfg.dani.tfg.features.login;

import com.tfg.dani.tfg.base.BasePresenter;
import com.tfg.dani.tfg.core.entities.User;
import com.tfg.dani.tfg.core.interactors.UserInteractor;

import nucleus.presenter.RxPresenter;

/**
 * Created by dani on 31/10/15.
 */
public class LoginPresenter extends BasePresenter<LoginViewInterface> {

    private UserInteractor mUserInteractor;

    public static LoginPresenter getInstance() {
        return new LoginPresenter();
    }

    public LoginPresenter() {
        mUserInteractor = UserInteractor.getInstance();
    }

    public void loginUser(String email, String authToken) {

    }
}

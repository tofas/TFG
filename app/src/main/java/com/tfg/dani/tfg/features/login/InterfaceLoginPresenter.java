package com.tfg.dani.tfg.features.login;

import com.tfg.dani.tfg.base.BasePresenterInterface;

/**
 * Created by dani on 21/11/15.
 */
public interface InterfaceLoginPresenter extends BasePresenterInterface {

    void loginUser(String mail, String token);
}

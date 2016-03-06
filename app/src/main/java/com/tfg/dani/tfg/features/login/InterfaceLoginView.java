package com.tfg.dani.tfg.features.login;

import com.tfg.dani.tfg.core.base.BaseViewInterface;
import com.tfg.dani.tfg.core.entities.User;

/**
 * Created by dani on 21/11/15.
 */
public interface InterfaceLoginView extends BaseViewInterface {

    void onUserReceived(User user);
}

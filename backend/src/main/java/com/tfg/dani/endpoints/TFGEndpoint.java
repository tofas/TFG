/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.tfg.dani.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.tfg.dani.endpoints.core.entities.User;
import com.tfg.dani.endpoints.features.UsersPresenter;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "tfgApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "endpoints.dani.tfg.com",
                ownerName = "endpoints.dani.tfg.com",
                packagePath = ""
        )
)
public class TFGEndpoint {

    private UsersPresenter mUsersPresenter;

    @ApiMethod(name = "login", httpMethod = "post")
    public User login(@Named("email") String email, @Named("authToken") String authToken) {
        mUsersPresenter = UsersPresenter.getInstance();
        return mUsersPresenter.login(email, authToken);
    }

}

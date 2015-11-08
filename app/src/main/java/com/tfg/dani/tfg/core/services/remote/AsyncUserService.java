package com.tfg.dani.tfg.core.services.remote;

import com.tfg.dani.tfg.core.services.ServiceBuilder;
import com.tfg.dani.tfg.core.entities.User;
import com.tfg.dani.tfg.core.services.restservices.UserService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dani on 31/10/15.
 */
public class AsyncUserService {

    public void login(String email, String authToken) {
        UserService userService = ServiceBuilder.createService(UserService.class);

        userService.login(email, authToken, new Callback<User>() {
            @Override
            public void success(User user, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}

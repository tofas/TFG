package com.tfg.dani.tfg.core.services.restservices;

import com.tfg.dani.tfg.core.entities.User;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by dani on 31/10/15.
 */
public interface UserService {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @POST("/users/login")
    void login(@Body("email") String email, @Body("authToken") String authToken, Callback<User> cb);
}

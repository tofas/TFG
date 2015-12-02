package com.tfg.dani.tfg.core.services.restservices;

import com.tfg.dani.tfg.core.entities.User;

import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by dani on 31/10/15.
 */
public interface UserService {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter
    @POST("/users/login")
    Observable<User> login(@Body String email, @Body String authToken);
}

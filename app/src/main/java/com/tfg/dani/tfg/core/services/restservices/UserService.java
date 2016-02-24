package com.tfg.dani.tfg.core.services.restservices;

import com.tfg.dani.tfg.core.entities.User;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by dani on 31/10/15.
 */
public interface UserService {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter
    @GET("/login/{email}/{authToken}")
    Observable<User> login(@Path("email") String email, @Path("authToken") String authToken);
}

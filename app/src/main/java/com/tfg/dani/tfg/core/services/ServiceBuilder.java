package com.tfg.dani.tfg.core.services;

import retrofit.RestAdapter;

/**
 * Created by dani on 31/10/15.
 */
public class ServiceBuilder {

    // Testing url on localhost
    private static final String BASE_URL = "http://localhost:8080/_ah/api";

    public static <S> S createService(Class<S> serviceClass) {

        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .build()
                .create(serviceClass);
    }
}

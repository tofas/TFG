package com.tfg.dani.tfg.core.services;

/*import com.google.appengine.repackaged.org.codehaus.jackson.map.deser.DateDeserializer;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ser.std.DateSerializer;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;*/

import java.util.Date;

import retrofit.RestAdapter;

import retrofit.converter.GsonConverter;

/**
 * Created by dani on 31/10/15.
 */
public class ServiceBuilder {

    // Testing url on localhost
    private static final String BASE_URL = "localhost:8080";

    /*private static GsonConverter gsonConverter =
            new GsonConverter(
                    new GsonBuilder()
                            .registerTypeAdapter(Date.class, new DateDeserializer())
                            .registerTypeAdapter(Date.class, new DateSerializer())
                            .addSerializationExclusionStrategy(new ExclusionStrategy() {
                                @Override
                                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                                    final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                                    return expose != null && !expose.serialize();
                                }

                                @Override
                                public boolean shouldSkipClass(Class<?> aClass) {
                                    return false;
                                }
                            })
                            .addDeserializationExclusionStrategy(new ExclusionStrategy() {
                                @Override
                                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                                    final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                                    return expose != null && !expose.deserialize();
                                }

                                @Override
                                public boolean shouldSkipClass(Class<?> aClass) {
                                    return false;
                                }
                            })
                            .create()
            );*/

    public static <S> S createService(Class<S> serviceClass) {

        return new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .build()
                .create(serviceClass);
    }
}

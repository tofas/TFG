package com.tfg.dani.endpoints.core;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.tfg.dani.endpoints.core.entities.User;

/**
 * Created by dani on 31/10/15.
 */
public class OfyService {
    static {
        ObjectifyService.register(User.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}

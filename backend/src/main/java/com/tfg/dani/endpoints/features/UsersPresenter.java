package com.tfg.dani.endpoints.features;

import com.google.api.server.spi.response.ConflictException;
import com.tfg.dani.endpoints.core.entities.User;

import static com.tfg.dani.endpoints.core.OfyService.ofy;

/**
 * Created by dani on 31/10/15.
 */
public class UsersPresenter {

    public static UsersPresenter getInstance() {
        return new UsersPresenter();
    }

    public User login(String email, String apiToken) {

        User userFind = findExistingUser(email);

        //TODO: retornar toda la info disponible (user descriptor)

        if(userFind == null) {
            User user = new User(email, apiToken);
            ofy().save().entity(user).now();
            return user;
        } else {
            return userFind;
        }
    }

    //Private method to retrieve a <code>Quote</code> record
    private User findExistingUser(String email) {
        return ofy().load().type(User.class).filter("email",email).first().now();
    }
}

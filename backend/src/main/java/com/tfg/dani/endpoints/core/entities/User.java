package com.tfg.dani.endpoints.core.entities;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by dani on 31/10/15.
 */
@Entity
public class User {

    @Id
    Long id;
    String email;
    String authToken;

    public User(String email, String authToken) {
        setEmail(email);
        setAuthToken(authToken);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

}

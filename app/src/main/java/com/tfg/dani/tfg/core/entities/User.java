package com.tfg.dani.tfg.core.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dani on 31/10/15.
 */
public class User {

    @SerializedName("id")
    int mId;
    @SerializedName("email")
    String mEmail;
    @SerializedName("authToken")
    String mAuthToken;

    public User(int id, String mEmail, String mAuthToken) {
        this.mId = id;
        this.mEmail = mEmail;
        this.mAuthToken = mAuthToken;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmAuthToken() {
        return mAuthToken;
    }

    public void setmAuthToken(String mAuthToken) {
        this.mAuthToken = mAuthToken;
    }

}

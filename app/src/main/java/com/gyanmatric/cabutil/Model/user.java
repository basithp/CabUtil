package com.gyanmatric.cabutil.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mbasith on 30/01/17.
 */

public class User {

    public static User INVALID_USER = new User("invalid");

    @SerializedName("userType")
    String userType;

    public User() {
    }

    public User(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getUserType().equals(((User) obj).getUserType());
    }
}

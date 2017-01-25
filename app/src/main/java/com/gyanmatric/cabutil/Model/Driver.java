package com.gyanmatric.cabutil.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mbasith on 25/01/17.
 */

public class Driver {

    @SerializedName("name")
    String name;

    @SerializedName("id")
    int id;

    public Driver(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

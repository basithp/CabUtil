package com.gyanmatric.cabutil.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mbasith on 25/01/17.
 */

public class DriverListResponse {
    @SerializedName("drivers")
    List<Driver> driverList;

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }
}

package com.gyanmatric.cabutil.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mbasith on 26/01/17.
 */

public class DriverDetailResponse {

    @SerializedName("passengers")
    List<Passenger> passengerList;

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}

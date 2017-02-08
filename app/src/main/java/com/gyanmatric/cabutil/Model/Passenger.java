package com.gyanmatric.cabutil.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mbasith on 26/01/17.
 */

public class Passenger {

    @SerializedName("empCode")
    int empCode;

    @SerializedName("name")
    String empName;

    @SerializedName("from")
    String from;

    @SerializedName("to")
    String to;

    @SerializedName("status")
    String empStatus;

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }
}

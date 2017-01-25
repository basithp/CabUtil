package com.gyanmatric.cabutil.Network;

import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.Model.DriverDetailResponse;
import com.gyanmatric.cabutil.Model.DriverListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mbasith on 25/01/17.
 */

public interface APIInterface {

    @GET("/driver.json")
    Call<DriverListResponse> getListOfDriver();

    @GET("/driver/{id}.json")
    Call<DriverDetailResponse> getListOfPassenger(@Path("id") int id);
}

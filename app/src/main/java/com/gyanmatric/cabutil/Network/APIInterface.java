package com.gyanmatric.cabutil.Network;

import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.Model.DriverDetailResponse;
import com.gyanmatric.cabutil.Model.DriverListResponse;
import com.gyanmatric.cabutil.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mbasith on 25/01/17.
 */

public interface APIInterface {

    @GET("/driver.json")
    Call<DriverListResponse> getListOfDriver();

    @GET("/driver/{id}.json")
    Call<DriverDetailResponse> getListOfPassenger(@Path("id") int id);

    @FormUrlEncoded
    @POST("/login")
    Call<User> authenticateUser(@Field("userName") String id, @Field("pwd") String pwd);
}

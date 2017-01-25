package com.gyanmatric.cabutil.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mbasith on 25/01/17.
 */

public class APIClient {

    public static final String BASE_URL = "http://192.168.1.6:8080";
    private static Retrofit retrofit;

    public static Retrofit getAPIClient(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

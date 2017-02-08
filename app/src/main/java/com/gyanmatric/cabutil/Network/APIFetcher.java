package com.gyanmatric.cabutil.Network;

import android.util.Log;
import android.view.View;

import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.Model.DriverDetailResponse;
import com.gyanmatric.cabutil.Model.DriverListResponse;
import com.gyanmatric.cabutil.Model.Passenger;
import com.gyanmatric.cabutil.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mbasith on 26/01/17.
 */

public class APIFetcher {

    public static void getDriversFromServer(final APIDriverFetcherCallback listener){

        APIInterface apiService = APIClient.getAPIClient().create(APIInterface.class);
        Call<DriverListResponse> call = apiService.getListOfDriver();

        call.enqueue(new Callback<DriverListResponse>() {
            @Override
            public void onResponse(Call<DriverListResponse> call, Response<DriverListResponse> response) {
                List<Driver> driverList = response.body().getDriverList();
                listener.onDriverDataFetched(driverList);
            }

            @Override
            public void onFailure(Call<DriverListResponse> call, Throwable t) {
                Log.e("HOME_ACTIVITY","Fetching Error");
            }
        });
    }

    public static void getPassengerFromServer(int driverId, final APIPassengerFetcherCallback listener){

        APIInterface apiService = APIClient.getAPIClient().create(APIInterface.class);
        Call<DriverDetailResponse> call = apiService.getListOfPassenger(driverId);
        call.enqueue(new Callback<DriverDetailResponse>() {
            @Override
            public void onResponse(Call<DriverDetailResponse> call, Response<DriverDetailResponse> response) {
                List<Passenger> passengerList = response.body().getPassengerList();
                listener.onPassengerDataFetched(passengerList);
            }

            @Override
            public void onFailure(Call<DriverDetailResponse> call, Throwable t) {
                Log.e("PASSENGERDETAIL","Wrong Driver Details");
            }
        });
    }

    public static void authenticateUserforLogin(String userName, String pwd, final APIAuthenticationCallback listener){
        APIInterface apiInterface = APIClient.getAPIClient().create(APIInterface.class);
        Call<User> call = apiInterface.authenticateUser(userName,pwd);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                listener.onUserAuthenticated(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
    public interface APIDriverFetcherCallback{
        void onDriverDataFetched(List<Driver> driverList);
    }

    public interface APIPassengerFetcherCallback{
        void onPassengerDataFetched(List<Passenger> passengerList);
    }

    public  interface APIAuthenticationCallback{
        void onUserAuthenticated(User user);
    }
}


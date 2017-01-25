package com.gyanmatric.cabutil.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gyanmatric.cabutil.Adaptor.RvDriverListAdaptor;
import com.gyanmatric.cabutil.Adaptor.RvPassengerListAdaptor;
import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.Model.DriverDetailResponse;
import com.gyanmatric.cabutil.Model.DriverListResponse;
import com.gyanmatric.cabutil.Model.Passenger;
import com.gyanmatric.cabutil.Network.APIClient;
import com.gyanmatric.cabutil.Network.APIInterface;
import com.gyanmatric.cabutil.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_driver);
        int driverId = getIntent().getIntExtra("driverId",0);
        initPassengerDetails(driverId);
    }

    private void initPassengerDetails(int driverId) {

        final LinearLayout spinnerLayout = (LinearLayout) findViewById(R.id.ll_spinner_activity_detail_driver);
        spinnerLayout.setVisibility(View.VISIBLE);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_detail_driver);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final RvPassengerListAdaptor rvPassengerListAdaptor = new RvPassengerListAdaptor();
        recyclerView.setAdapter(rvPassengerListAdaptor);

        APIInterface apiService = APIClient.getAPIClient().create(APIInterface.class);
        Call<DriverDetailResponse> call = apiService.getListOfPassenger(driverId);
        call.enqueue(new Callback<DriverDetailResponse>() {
            @Override
            public void onResponse(Call<DriverDetailResponse> call, Response<DriverDetailResponse> response) {
                List<Passenger> passengerList = response.body().getPassengerList();
                rvPassengerListAdaptor.setDriverList(passengerList);
                rvPassengerListAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DriverDetailResponse> call, Throwable t) {
                Log.e("PASSENGERDETAIL","Wrong Driver Details");
            }
        });
    }
}

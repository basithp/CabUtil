package com.gyanmatric.cabutil.Activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.gyanmatric.cabutil.Adaptor.RvPassengerListAdaptor;
import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.Model.DriverDetailResponse;
import com.gyanmatric.cabutil.Model.Passenger;
import com.gyanmatric.cabutil.Network.APIClient;
import com.gyanmatric.cabutil.Network.APIFetcher;
import com.gyanmatric.cabutil.Network.APIInterface;
import com.gyanmatric.cabutil.R;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDriverActivity extends FragmentActivity implements OnMapReadyCallback, APIFetcher.APIPassengerFetcherCallback, SwipeRefreshLayout.OnRefreshListener{

    private GoogleMap mMap;
    private int driverId = 0;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_driver);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_driver);
        mapFragment.getMapAsync(this);

        driverId = getIntent().getIntExtra("driverId",0);
        initUIElements();
        initPassengerDetails(driverId);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPrepareOptionsPanel(view, menu);
    }



    private void initUIElements(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        toolbar.setTitle("Route Info");

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sr_detail_driver);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_detail_driver);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void initPassengerDetails(int driverId) {
        APIFetcher.getPassengerFromServer(driverId,this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onPassengerDataFetched(List<Passenger> passengerList) {

        final LinearLayout spinnerLayout = (LinearLayout) findViewById(R.id.ll_spinner_activity_detail_driver);
        spinnerLayout.setVisibility(View.VISIBLE);

        final RvPassengerListAdaptor rvPassengerListAdaptor = new RvPassengerListAdaptor();
        if(passengerList.size() > 0) {
            rvPassengerListAdaptor.setDriverList(passengerList);
            recyclerView.setAdapter(rvPassengerListAdaptor);
            spinnerLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        APIFetcher.getPassengerFromServer(driverId,this);
        swipeRefreshLayout.setRefreshing(false);
    }


}

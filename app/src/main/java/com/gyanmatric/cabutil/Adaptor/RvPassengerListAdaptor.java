package com.gyanmatric.cabutil.Adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyanmatric.cabutil.Interfaces.RvOnItemClickListner;
import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.Model.Passenger;
import com.gyanmatric.cabutil.R;

import java.util.List;

/**
 * Created by mbasith on 26/01/17.
 */

public class RvPassengerListAdaptor extends RecyclerView.Adapter<RvPassengerListAdaptor.PassengerViewHolder>{
    private List<Passenger> passengerList;
    private RvOnItemClickListner rvOnItemClickListner;
    public RvPassengerListAdaptor() {
    }

    public void setDriverList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public RvPassengerListAdaptor.PassengerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_driver_view,parent,false);
        return new RvPassengerListAdaptor.PassengerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PassengerViewHolder holder, int position) {
        final Passenger passenger = passengerList.get(position);
        holder.tvStatus.setText(passenger.getEmpName());
        holder.tvFrom.setText(passenger.getFrom());
        holder.tvTo.setText(passenger.getTo());
        holder.tvStatus.setText(passenger.getEmpStatus().toString());
    }


    @Override
    public int getItemCount() {
        return passengerList.size();
    }

    public class PassengerViewHolder extends RecyclerView.ViewHolder{

        private TextView tvPassengerName;
        private TextView tvFrom;
        private TextView tvTo;
        private TextView tvStatus;

        private LinearLayout llRvParent;

        public PassengerViewHolder(View view) {
            super(view);
            tvPassengerName = (TextView) view.findViewById(R.id.tv_pasenger_name);
            tvFrom = (TextView) view.findViewById(R.id.tv_passenger_from);
            tvTo = (TextView) view.findViewById(R.id.tv_passenger_to);
            tvStatus = (TextView) view.findViewById(R.id.tv_passenger_status);
            llRvParent = (LinearLayout) view.findViewById(R.id.ll_rv_passenger_parent);
        }
    }
}

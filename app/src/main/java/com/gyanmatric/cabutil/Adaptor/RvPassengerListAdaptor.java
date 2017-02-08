package com.gyanmatric.cabutil.Adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
                .inflate(R.layout.rv_passenger_view,parent,false);
        return new RvPassengerListAdaptor.PassengerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PassengerViewHolder holder, int position) {
        final Passenger passenger = passengerList.get(position);
        holder.tvPassengerName.setText(passenger.getEmpName());
        holder.tvFrom.setText(passenger.getFrom());
        holder.tvTo.setText(passenger.getTo());
        holder.tvStatus.setText(passenger.getEmpStatus());
        Glide.with(holder.ivPassnegerDp.getContext())
                .load("https://pbs.twimg.com/profile_images/451489167659524096/5eHq-FXQ.jpeg")
                .fitCenter()
                .into(holder.ivPassnegerDp);
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
        private ImageView ivPassnegerDp;
        private LinearLayout llRvParent;

        public PassengerViewHolder(View view) {
            super(view);
            tvPassengerName = (TextView) view.findViewById(R.id.tv_pasenger_name);
            tvFrom = (TextView) view.findViewById(R.id.tv_passenger_from);
            tvTo = (TextView) view.findViewById(R.id.tv_passenger_to);
            tvStatus = (TextView) view.findViewById(R.id.tv_passenger_status);
            ivPassnegerDp = (ImageView) view.findViewById(R.id.iv_rv_passenger);
            llRvParent = (LinearLayout) view.findViewById(R.id.ll_rv_passenger_parent);
        }
    }
}

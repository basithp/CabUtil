package com.gyanmatric.cabutil.Adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyanmatric.cabutil.Interfaces.RvOnItemClickListner;
import com.gyanmatric.cabutil.Model.Driver;
import com.gyanmatric.cabutil.R;

import java.util.List;

/**
 * Created by mbasith on 25/01/17.
 */

public class RvDriverListAdaptor extends RecyclerView.Adapter<RvDriverListAdaptor.DriverViewHolder>  {
    private List<Driver> driverList;
    private RvOnItemClickListner rvOnItemClickListner;
    public RvDriverListAdaptor(List<Driver> driverList,RvOnItemClickListner listner) {
        this.driverList = driverList;
        this.rvOnItemClickListner = listner;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    @Override
    public DriverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_driver_view,parent,false);
        return new DriverViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DriverViewHolder holder, int position) {
        final Driver driver = driverList.get(position);
        holder.tvDriverName.setText(driver.getName());
        holder.llRvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvOnItemClickListner.onItemClicked(driver);
            }
        });
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    public class DriverViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDriverName;
        private LinearLayout llRvParent;

        public DriverViewHolder(View view) {
            super(view);
            tvDriverName = (TextView) view.findViewById(R.id.tv_driver_name);
            llRvParent = (LinearLayout) view.findViewById(R.id.ll_rv_parent);
        }
    }


}

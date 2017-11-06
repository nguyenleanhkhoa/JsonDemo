package com.example.admin.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 9/1/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    ArrayList<product> products;
    Context context;

    public RecycleAdapter(ArrayList<product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtname.setText(products.get(position).getTenSP());
        holder.imgHinh.setImageResource(products.get(position).getHinh());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtname;
        ImageView imgHinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname=(TextView) itemView.findViewById(R.id.txttensp);
            imgHinh=(ImageView) itemView.findViewById(R.id.imgproduct);
        }
    }

}

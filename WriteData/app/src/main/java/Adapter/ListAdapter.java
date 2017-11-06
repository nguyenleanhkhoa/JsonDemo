package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.writedata.R;

import java.util.ArrayList;

import Model.Hoadon;
import Model.Khachhang;

/**
 * Created by ADMIN on 9/12/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    ArrayList<Khachhang>dsKhachhang;
    Context context;

    public ListAdapter(ArrayList<Khachhang> dsKhachhang, Context context) {
        this.dsKhachhang = dsKhachhang;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemrow=layoutInflater.inflate(R.layout.item,parent,false);


        return new ViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Khachhang kh = dsKhachhang.get(position);
        holder.txtnamefull.setText(kh.Lastname);
        holder.txtsdt.setText(kh.Phone);
    }

    @Override
    public int getItemCount() {
        return dsKhachhang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnamefull,txtsdt;
        public ViewHolder(View itemView) {
            super(itemView);
            txtnamefull= itemView.findViewById(R.id.txtname);
            txtsdt= itemView.findViewById(R.id.txtphonenum);
        }
    }
}

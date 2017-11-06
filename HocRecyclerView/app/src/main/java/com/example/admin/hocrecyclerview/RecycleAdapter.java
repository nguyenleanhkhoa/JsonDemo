package com.example.admin.hocrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ADMIN on 9/4/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>
{

    ArrayList<Student>students;
    Context context;

    public RecycleAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View row=layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtname.setText(students.get(position).getName());
        holder.txtlop.setText(students.get(position).getLop());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtname,txtlop;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.textName);
            txtlop=itemView.findViewById(R.id.textlop);
        }
    }
}

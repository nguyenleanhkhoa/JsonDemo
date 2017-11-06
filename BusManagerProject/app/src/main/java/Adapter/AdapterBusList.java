package Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.busmanagerproject.R;

import java.util.List;

import Model.Bus;

/**
 * Created by ADMIN on 10/23/17.
 */

public class AdapterBusList extends ArrayAdapter<Bus> {
    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<Bus> objects;
    public AdapterBusList(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Bus> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        View row=layoutInflater.inflate(this.resource,null);
        TextView txtBusId=row.findViewById(R.id.txtbusid);
        TextView txtBusNumber=row.findViewById(R.id.txtbusnumber);

        Bus bus=this.objects.get(position);
        txtBusId.setText("số "+String.valueOf(bus.getMaXeBus()));
        txtBusNumber.setText(String.valueOf(bus.getSoXeBus()));
        return row;
    }
}

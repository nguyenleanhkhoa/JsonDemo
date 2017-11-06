package Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import Model.Employer;

/**
 * Created by ADMIN on 10/23/17.
 */

public class AdapterEmployer extends ArrayAdapter<Employer>{
    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<Employer> objects;
    public AdapterEmployer(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Employer> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        return super.getView(position, convertView, parent);
    }
}

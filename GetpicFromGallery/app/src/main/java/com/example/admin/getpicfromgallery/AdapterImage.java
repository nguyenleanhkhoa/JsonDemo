package com.example.admin.getpicfromgallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ADMIN on 11/02/17.
 */

public class AdapterImage extends ArrayAdapter<ImageHinh> {
    @NonNull Activity context;
    int resource;
    @NonNull List<ImageHinh> objects;
    private Bitmap bmp;
    public AdapterImage(@NonNull Activity context, int resource, @NonNull List<ImageHinh> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View row=layoutInflater.inflate(this.resource,null);
        ImageView imageView=row.findViewById(R.id.imageHinh1);
        ImageHinh imgPath=this.objects.get(position);

        imageView.setImageURI(Uri.parse(imgPath.getPicPath()));
        return row;
    }
}

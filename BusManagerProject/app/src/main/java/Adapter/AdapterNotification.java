package Adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.busmanagerproject.R;

import java.util.List;
import Model.Notification;
/**
 * Created by ADMIN on 10/22/17.
 */

public class AdapterNotification extends ArrayAdapter<Model.Notification> {
    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<Model.Notification> objects;
    public AdapterNotification(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Model.Notification> objects) {
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
        TextView txtsoTB=row.findViewById(R.id.txtsothogbao);
        TextView txtnoidungtb=row.findViewById(R.id.txtNdThogbao);
        TextView txtdateTb=row.findViewById(R.id.txtdate);

        Notification notify=this.objects.get(position);

        txtsoTB.setText("Thông báo : "+String.valueOf(notify.getNotify_Id()));
        txtnoidungtb.setText(notify.getNotify_Context());
        txtdateTb.setText(notify.getNotify_Date());
        return row;
    }
}

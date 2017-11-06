package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anhkhoa.masterjson1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.Itune;

/**
 * Created by anh khoa on 11/6/2017.
 */

public class ItuneAdapter extends RecyclerView.Adapter<ItuneAdapter.ViewHolder>  {

    Context context;
    ArrayList<Itune>listItune;

    public ItuneAdapter(Context context, ArrayList<Itune> listItune) {
        this.context = context;
        this.listItune = listItune;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemview=layoutInflater.inflate(R.layout.item_itune,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTrackname.setText(listItune.get(position).getTrackName());
        holder.txtArtistname.setText(listItune.get(position).getArtistName());
        Picasso.with(context).load(listItune.get(position).getArtworkUrl100()).into(holder.imghinh);
    }

    @Override
    public int getItemCount() {
        return listItune.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTrackname,txtArtistname;
        ImageView imghinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTrackname=itemView.findViewById(R.id.txtnameTrack);
            txtArtistname=itemView.findViewById(R.id.txtnameArtist);
            imghinh=itemView.findViewById(R.id.imgArtist);
        }
    }
    public void remove(int position){
        listItune.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listItune.size());
    }
    public void clear() {
        int size = this.listItune.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.listItune.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }
}

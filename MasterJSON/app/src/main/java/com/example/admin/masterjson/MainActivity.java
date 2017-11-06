package com.example.admin.masterjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Process;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.masterjson.model.ItuneStuff;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    TextView txttype,txtartistname,txtcollname,txttrackname,txtkind;
    ImageView imgartist;
    Button btnget;
    String imgURL;
    Bitmap img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonituneTask jsonituneTask=new JsonituneTask(MainActivity.this);
                jsonituneTask.execute();
            }
        });

    }

    private void addControl() {
        txttype= (TextView) findViewById(R.id.typeJS);
        txtartistname= (TextView) findViewById(R.id.artistnameJS);
        txtcollname= (TextView) findViewById(R.id.collectionameJS);
        txttrackname= (TextView) findViewById(R.id.tracknameJS);
        txtkind= (TextView) findViewById(R.id.kindnameJS);
        imgartist= (ImageView) findViewById(R.id.imgartist1);
        btnget= (Button) findViewById(R.id.btngetdata);
    }

    private class JsonituneTask extends AsyncTask<String,Void,ItuneStuff>{
        Context context;
        ProgressDialog progressdialog;

        public JsonituneTask(Context context) {
            this.context = context;
            progressdialog=new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressdialog.setTitle("Downloading info...");
            progressdialog.show();
        }

        @Override
        protected ItuneStuff doInBackground(String... strings) {
            ItuneStuff ituneStuff=new ItuneStuff();
            String data =((new ItuneHTTPClient())).getItunesStuffData();
            try{
                ituneStuff=JsonItuneParser.getItunestuff(data);
                imgURL=ituneStuff.getArtistViewURL();
                img=((new ItuneHTTPClient())).getBitmapFromURL(imgURL);
            }catch (JSONException e) {
                e.printStackTrace();
            }
            return ituneStuff;
        }

        @Override
        protected void onPostExecute(ItuneStuff ituneStuff) {
            super.onPostExecute(ituneStuff);
            txtartistname.setText(ituneStuff.getArtistName());
            txttrackname.setText(ituneStuff.getTrackName());
            txtkind.setText(ituneStuff.getKind());
            txtcollname.setText(ituneStuff.getCollectionName());
            txttype.setText(ituneStuff.getType());
            imgartist.setImageBitmap(img);
            if(progressdialog.isShowing()){
                progressdialog.dismiss();
            }
        }
    }
}

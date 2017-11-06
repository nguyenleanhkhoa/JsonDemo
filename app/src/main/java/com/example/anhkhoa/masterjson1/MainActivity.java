package com.example.anhkhoa.masterjson1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.ItuneAdapter;
import Client.ItuneHttpClient;
import JsonParser.ItuneParser;
import model.Itune;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Itune>listMusic;
    ItuneAdapter adapterMusic;
    SearchView searchItune;
    ArrayList<Itune>ituneArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ituneArrayList=new ArrayList<>();
        addControl();
        showInformation();
        addEvent();
    }
    private void showInformation(){
        JSONItuneTask jsonItuneTask=new JSONItuneTask(MainActivity.this);
        jsonItuneTask.execute();

    }
    private void addEvent() {
        searchItune.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!TextUtils.isEmpty(query.toString())){
                    adapterMusic.clear();
                    JSONItuneTaskSearch jsonItuneTaskSearch=new JSONItuneTaskSearch(MainActivity.this,query);
                    jsonItuneTaskSearch.execute();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    adapterMusic.clear();
                    JSONItuneTask jsonItuneTask=new JSONItuneTask(MainActivity.this);
                    jsonItuneTask.execute();
                }
                return false;
            }
        });

    }

    private void addControl() {
        searchItune=findViewById(R.id.searchViewItune);
        recyclerView=findViewById(R.id.RecyclerItune);
        listMusic=new ArrayList<>();
        adapterMusic=new ItuneAdapter(getApplicationContext(),listMusic);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    private class JSONItuneTask extends AsyncTask<String,Void ,Itune>{
        Context context;
        ProgressDialog progressDialog;

        public JSONItuneTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Downloading Information from Itune....");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Itune itune) {
            super.onPostExecute(itune);
            recyclerView.setAdapter(adapterMusic);
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        protected Itune doInBackground(String... strings) {
            Itune itune=new Itune();
            ItuneHttpClient  ituneHttpClient=new ItuneHttpClient();
            String data =(ituneHttpClient.getItuneData());

            try{
                for(int i=0;i<100;i++){
                    itune=ItuneParser.getItune(data,i);
                    listMusic.add(itune);
                    ituneArrayList.add(itune);
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
            return itune;
        }
    }

    private class JSONItuneTaskSearch extends AsyncTask<String,Void ,Itune>{
        Context context;
        ProgressDialog progressDialog;
        String nextext;

        public JSONItuneTaskSearch(Context context,String nextext) {
            this.context = context;
            this.nextext=nextext;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Searching....");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Itune itune) {
            super.onPostExecute(itune);
            recyclerView.setAdapter(adapterMusic);
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        protected Itune doInBackground(String... strings) {
            Itune itune=new Itune();
            ItuneHttpClient  ituneHttpClient=new ItuneHttpClient();
            String data =(ituneHttpClient.getItuneData());

            try{
                for (int i=0;i<100;i++){
                    itune=ItuneParser.getSearchItune(data,i,nextext);
                    listMusic.add(itune);
                    adapterMusic.clear();
                    if(listMusic.get(i).getTrackName().equalsIgnoreCase(nextext)){
                        listMusic.add(itune);
                    }
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
            return itune;
        }
    }

}


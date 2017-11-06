package com.example.admin.masterjson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ADMIN on 9/26/2017.
 */

public class ItuneHTTPClient {
    private static String BASE_URL= "https://itunes.apple.com/search?term=son+tung+mtp";

    public String getItunesStuffData(){
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        try{
            httpURLConnection=(HttpURLConnection) (new URL(BASE_URL)).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            //Let read the respond
            StringBuffer stringBuffer=new StringBuffer();
            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line =null;
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\r\n");
            }
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuffer.toString();

        }catch (Throwable T){
            T.printStackTrace();
        }
        finally {
            try{
                inputStream.close();
                httpURLConnection.disconnect();

             } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public Bitmap getBitmapFromURL(String stringUrl){
        Bitmap bitmap=null;
        try{
            URL url=new URL(stringUrl);
            InputStream inputStream=url.openStream();
            bitmap= BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }
}

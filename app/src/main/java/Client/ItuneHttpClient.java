package Client;

import android.renderscript.ScriptGroup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anh khoa on 11/6/2017.
 */

public class ItuneHttpClient {

    private static String BASE_URL="https://itunes.apple.com/search?term=noo+phuoc+thinh";
    public String getItuneData(){
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        try{
            httpURLConnection=(HttpURLConnection) (new URL(BASE_URL)).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            //read the Respond
            StringBuffer stringBuffer=new StringBuffer();
            inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\r\n");
            }
            inputStream.close();
            httpURLConnection.disconnect();

            return stringBuffer.toString();
        }catch (Throwable t){
            t.printStackTrace();
        }
        finally {
            try{
                inputStream.close();
                httpURLConnection.disconnect();
            }catch(Throwable t){
                t.printStackTrace();
            }

        }
        return null;
    }
}

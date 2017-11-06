package JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.Itune;

/**
 * Created by anh khoa on 11/6/2017.
 */

public class ItuneParser {

    public static Itune getItune(String url,int i) throws JSONException{
        Itune itune=new Itune();
        JSONObject ItuneObject=new JSONObject(url);
        JSONArray resultJsonArray=ItuneObject.getJSONArray("results");
            JSONObject artistObject=resultJsonArray.getJSONObject(i);
            itune.setArtistName(getString("artistName",artistObject));
            itune.setTrackName(getString("trackName",artistObject));
            itune.setArtworkUrl100(getString("artworkUrl100",artistObject));
       return itune;
    }


    public static Itune getSearchItune(String url,int j,String TrackName) throws JSONException{

        Itune itune=new Itune();
        JSONObject ItuneObject=new JSONObject(url);

        JSONArray resultJsonArray=ItuneObject.getJSONArray("results");


        for(int i=0;i<resultJsonArray.length();i++){
            JSONObject artistObject=  resultJsonArray.getJSONObject(j);
            if(TrackName.equalsIgnoreCase(artistObject.getString("trackName"))){
                itune.setArtistName(getString("artistName",artistObject));
                itune.setTrackName(getString("trackName",artistObject));
                itune.setArtworkUrl100(getString("artworkUrl100",artistObject));
                return  itune;
            }
           // if(TrackName.equalsIgnoreCase(getString("trackName",artistObject))){
           // }
        }
       return itune;
    }


    public JSONObject SearchObject(String newtext) throws JSONException {
        String trackname;
        JSONObject ItuneObject = null;
        JSONArray resultJsonArray=new JSONArray("results");
        for(int i=0;i<resultJsonArray.length();i++){
            JSONObject currentob=resultJsonArray.getJSONObject(i);
            trackname=currentob.getString("trackName");
            if(trackname.equalsIgnoreCase(newtext)){
                ItuneObject=currentob;
            }
        }

        return ItuneObject;
    }

    public static JSONObject jsonObject(String tagName,JSONObject jsonObject)throws JSONException{
        return jsonObject.getJSONObject(tagName);
    }

    private static String getString(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagName);
    }
}

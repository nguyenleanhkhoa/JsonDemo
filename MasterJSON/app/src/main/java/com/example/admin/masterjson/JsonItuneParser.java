package com.example.admin.masterjson;

import com.example.admin.masterjson.model.ItuneStuff;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ADMIN on 9/26/2017.
 */

public class JsonItuneParser {
    public static ItuneStuff getItunestuff(String data) throws JSONException{
        ItuneStuff itunestuff=new ItuneStuff();
        JSONObject ituneStuffJsonobject=new JSONObject(data);
        JSONArray resultJsonArray=ituneStuffJsonobject.getJSONArray("results");
        JSONObject artistObject=resultJsonArray.getJSONObject(0);
        itunestuff.setType(getString("wrapperType",artistObject));
        itunestuff.setKind(getString("kind",artistObject));
        itunestuff.setArtistName(getString("artistName",artistObject));
        itunestuff.setCollectionName(getString("collectionName",artistObject));
        itunestuff.setArtistViewURL(getString("artworkUrl100",artistObject));
        itunestuff.setTrackName(getString("trackName",artistObject));
        return itunestuff;
    }
    public static JSONObject getJsonObject(String tagname,JSONObject jsonObject)throws JSONException{
        return jsonObject.getJSONObject(tagname);
    }
    public static String getString(String tagname, JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagname);
    }
    public static int getInt(String tagname,JSONObject jsonObject) throws JSONException{
        return jsonObject.getInt(tagname);
    }
    public static boolean getBoolean(String tagname,JSONObject jsonObject) throws JSONException{
        return jsonObject.getBoolean(tagname);
    }
    public static float getFloat(String tagname,JSONObject jsonObject)throws JSONException {
        return (float) jsonObject.getDouble(tagname);
    }
}

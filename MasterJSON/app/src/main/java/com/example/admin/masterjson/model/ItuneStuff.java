package com.example.admin.masterjson.model;

/**
 * Created by ADMIN on 9/26/2017.
 */

public class ItuneStuff {
    private String type;
    private String kind;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String artistViewURL;

    public ItuneStuff() {
    }

    public ItuneStuff(String type, String kind, String artistName, String collectionName, String trackName, String artistViewURL) {
        this.type = type;
        this.kind = kind;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.artistViewURL = artistViewURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistViewURL() {
        return artistViewURL;
    }

    public void setArtistViewURL(String artistViewURL) {
        this.artistViewURL = artistViewURL;
    }
}

package model;

/**
 * Created by anh khoa on 11/6/2017.
 */

public class Itune {
    public String trackName;
    public String artistName;
    public String artworkUrl100;
    public Itune() {
    }

    public Itune(String trackName, String artistName, String artworkUrl100) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.artworkUrl100 = artworkUrl100;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }
}

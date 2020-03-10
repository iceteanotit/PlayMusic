package com.example.playmusic.models;

import com.example.basemodule.models.BaseModels;

public class Artist extends BaseModels {

    private String artist;
    private String numberOfAlbums;
    private String numberOfTracks;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumberOfAlbums() {
        return numberOfAlbums;
    }

    public void setNumberOfAlbums(String numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    public String getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(String numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }
}
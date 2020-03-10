package com.example.playmusic.models;

import com.example.basemodule.models.BaseModels;

public class Album extends BaseModels {

    private String album;
    private String artist;
    private String numberOfSong;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumberOfSong() {
        return numberOfSong;
    }

    public void setNumberOfSong(String numberOfSong) {
        this.numberOfSong = numberOfSong;
    }
}
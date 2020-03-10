package com.example.playmusic.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.playmusic.models.Album;
import com.example.playmusic.models.Artist;
import com.example.playmusic.models.Song;

import java.util.ArrayList;

public class SystemData {

    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> getSongs() {
        ArrayList<Song> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null
        );
        cursor.moveToFirst();

        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);

        while (cursor.isAfterLast() == false) {
            Song song = new Song();

            song.setData(cursor.getString(indexData));
            song.setTitle(cursor.getString(indexTitle));
            song.setSize(cursor.getInt(indexSize));
            song.setDuration(cursor.getInt(indexDuration));
            song.setArtist(cursor.getString(indexArtist));
            song.setAlbum(cursor.getString(indexAlbum));

            arr.add(song);
            cursor.moveToNext();
        }
        return arr;
    }

    public ArrayList<Album> getAlbums() {
        ArrayList<Album> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                null, null, null, null
        );
        cursor.moveToFirst();

        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST);
        int indexNumberOfSong = cursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS);

        while (cursor.isAfterLast() == false) {
            Album album = new Album();

            album.setAlbum(cursor.getString(indexAlbum));
            album.setArtist(cursor.getString(indexArtist));
            album.setNumberOfSong(cursor.getString(indexNumberOfSong));

            arr.add(album);
            cursor.moveToNext();
        }
        return arr;
    }

    public ArrayList<Artist> getArtist() {
        ArrayList<Artist> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                null, null, null, null
        );
        cursor.moveToFirst();

        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST);
        int indexNumberOfAlbums = cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_ALBUMS);
        int indexNumberOfTracks = cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS);

        while (cursor.isAfterLast() == false) {
            Artist artist = new Artist();

            artist.setArtist(cursor.getString(indexAlbum));
            artist.setNumberOfAlbums(cursor.getString(indexNumberOfAlbums));
            artist.setNumberOfTracks(cursor.getString(indexNumberOfTracks));

            arr.add(artist);
            cursor.moveToNext();
        }
        return arr;
    }
}
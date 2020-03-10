package com.example.playmusic.fragments.song;

import com.example.basemodule.base.BaseAdapterListener;
import com.example.playmusic.models.Song;

public interface SongItemListener extends BaseAdapterListener {
    void onItemSongClicked(Song item);
}
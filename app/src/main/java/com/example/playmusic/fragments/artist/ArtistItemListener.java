package com.example.playmusic.fragments.artist;

import com.example.basemodule.base.BaseAdapterListener;
import com.example.playmusic.models.Artist;

public interface ArtistItemListener extends BaseAdapterListener {
    void onItemArtistClicked(Artist item);
}
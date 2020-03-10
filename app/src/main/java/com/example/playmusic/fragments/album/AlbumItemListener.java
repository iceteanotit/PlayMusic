package com.example.playmusic.fragments.album;

import com.example.basemodule.base.BaseAdapterListener;
import com.example.playmusic.models.Album;

public interface AlbumItemListener extends BaseAdapterListener {
    void onItemAlbumClicked(Album item);
}
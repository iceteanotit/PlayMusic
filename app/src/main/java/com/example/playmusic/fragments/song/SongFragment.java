package com.example.playmusic.fragments.song;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.basemodule.base.BaseAdapter;
import com.example.basemodule.base.BaseFragment;
import com.example.playmusic.AppAdapter;
import com.example.playmusic.MainActivity;
import com.example.playmusic.R;
import com.example.playmusic.data.SystemData;
import com.example.playmusic.databinding.FragmentSongBinding;
import com.example.playmusic.models.Song;
import com.example.playmusic.service.MP3Service;

public class SongFragment extends BaseFragment<FragmentSongBinding> implements SongItemListener {

    private BaseAdapter<Song> adapter;
    private SystemData data;
    private MP3Service service;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new AppAdapter<>(getLayoutInflater(), R.layout.item_song);
        data = new SystemData(getContext());
        adapter.setData(data.getSongs());
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);

        MainActivity act = (MainActivity) getActivity();
        service = act.getService();
    }

    @Override
    public void onItemSongClicked(Song item) {
        int index = adapter.getData().indexOf(item);
        service.setSongData(adapter.getData());
        service.getController().create(index);
    }
}
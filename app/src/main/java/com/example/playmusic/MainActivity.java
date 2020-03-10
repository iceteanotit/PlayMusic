package com.example.playmusic;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.example.basemodule.base.BaseActivity;
import com.example.basemodule.base.BaseFragment;
import com.example.playmusic.databinding.ActivityMainBinding;
import com.example.playmusic.fragments.album.AlbumFragment;
import com.example.playmusic.fragments.artist.ArtistFragment;
import com.example.playmusic.fragments.song.SongFragment;
import com.example.playmusic.service.MP3Service;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {

    private SongFragment fmSong = new SongFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private ArtistFragment fmArtist = new ArtistFragment();

    private MP3Service service;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        doRequestPermission(
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                new BaseActivity.RequestPermissionCallback() {
                    @Override
                    public void onGranted() {
                        Intent intent = new Intent(
                                MainActivity.this, MP3Service.class
                        );
                        bindService(intent, connection, BIND_AUTO_CREATE);
                    }

                    @Override
                    public void onDenied() {
                        finish();
                    }
                }
        );
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MP3Service.MP3Binder binder = (MP3Service.MP3Binder) iBinder;
            service = binder.getService();
            initFragment();
            binding.nav.setOnNavigationItemSelectedListener(MainActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fmSong);
        transaction.add(R.id.container, fmArtist);
        transaction.add(R.id.container, fmAlbum);
        transaction.commit();
        showFragment(fmSong);
    }

    private void showFragment(BaseFragment fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.hide(fmSong);
        transaction.hide(fmArtist);
        transaction.hide(fmAlbum);
        transaction.show(fmShow);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_songs:
                showFragment(fmSong);
                break;
            case R.id.nav_albums:
                showFragment(fmAlbum);
                break;
            case R.id.nav_artists:
                showFragment(fmArtist);
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    public MP3Service getService() {
        return service;
    }
}
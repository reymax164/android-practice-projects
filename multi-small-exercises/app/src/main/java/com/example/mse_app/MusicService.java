package com.example.mse_app;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.yumefukakeru);
        mediaPlayer.setLooping(false);

        Toast.makeText(this, "Music Playing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();

        if (mediaPlayer != null) {
            if ("ACTION_PAUSE".equals(action)) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Toast.makeText(this, "Music Paused", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    Toast.makeText(this, "Music Playing", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();

        Toast.makeText(this, "Music Stopped", Toast.LENGTH_SHORT).show();
    }
}

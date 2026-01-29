package com.example.mse_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SimpleMusicPlayer extends AppCompatActivity {
    Button play, pause, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_music_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        play = findViewById(R.id.playMusic);
        pause = findViewById(R.id.pauseMusic);
        stop = findViewById(R.id.stopMusic);

        play.setOnClickListener(v -> {
            Intent playIntent = new Intent(this, MusicService.class);
            playIntent.setAction("ACTION_PLAY");

            startService(playIntent);
        });

        stop.setOnClickListener(v -> {
            stopService(new Intent(this, MusicService.class));
        });

        pause.setOnClickListener(v -> {
            Intent pauseIntent = new Intent(this, MusicService.class);
            pauseIntent.setAction("ACTION_PAUSE");

            startService(pauseIntent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MusicService.class));
    }
}
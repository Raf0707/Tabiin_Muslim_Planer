package com.example.tabiin.util;

import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.example.tabiin.R;

public class MyMediaPlayer {
    private static MediaPlayer instance;
    private android.media.MediaPlayer mediaPlayer;
    private String filePath;
    private int currentPosition;
    private SeekBar seekBar;

    public MyMediaPlayer() {
        mediaPlayer = new android.media.MediaPlayer();
    }

    public static MediaPlayer getInstance() {
        if (instance == null) {
            instance = new MediaPlayer();
        }
        return instance;
    }

    public void setSeekBar(SeekBar seekBar) {
        this.seekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    currentPosition = progress;
                    mediaPlayer.seekTo(currentPosition);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Ничего не делаем при начале перемещения ползунка
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Ничего не делаем при окончании перемещения ползунка
            }
        });
    }

    public void play(String filePath) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            mediaPlayer.start();
            this.filePath = filePath;
            if (seekBar != null) {
                seekBar.setMax(mediaPlayer.getDuration());
                updateSeekBar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            currentPosition = mediaPlayer.getCurrentPosition();
        }
    }

    public void resume() {
        if (!mediaPlayer.isPlaying() && filePath != null) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(filePath);
                mediaPlayer.prepare();
                mediaPlayer.seekTo(currentPosition);
                mediaPlayer.start();
                updateSeekBar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.reset();
        filePath = null;
        currentPosition = 0;
        if (seekBar != null) {
            seekBar.setProgress(0);
        }
    }

    public void release() {
        stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    private void updateSeekBar() {
        if (seekBar != null) {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            if (mediaPlayer.isPlaying()) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        updateSeekBar();
                    }
                };
                seekBar.postDelayed(runnable, 1000);
            }
        }
    }

    public void onComplete(ImageButton imageButton, int drawable) {
        mediaPlayer.setOnCompletionListener(mediaPlayer ->
                imageButton.setImageResource(drawable));
    }
}


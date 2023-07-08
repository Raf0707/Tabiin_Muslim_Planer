package com.example.tabiin.util;

import android.media.MediaPlayer;

public class MyMediaPlayer {
    private MediaPlayer mediaPlayer;
    private int currentPosition;
    private String filePath;

    static MediaPlayer instance;

    public MyMediaPlayer() {
        mediaPlayer = new MediaPlayer();
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
    }

    public void release() {
        stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public static MediaPlayer getInstance(){
        if(instance == null){
            instance = new MediaPlayer();
        }
        return instance;
    }

}


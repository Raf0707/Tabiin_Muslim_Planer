package com.example.tabiin.util;

import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tabiin.R;
import com.example.tabiin.objects.sures.Verse;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyMediaPlayer {
    private static MediaPlayer instance;
    private android.media.MediaPlayer mediaPlayer;
    private String filePath;
    private int currentPosition;
    private SeekBar seekBar;

    int counterClick = 0;

    boolean repeatOne = false;

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

    public void repeatOne() {
        // повторение одной композиции
        //mediaPlayer.start();
        /*counterClick++;

        if (counterClick % 2 == 1) { // исправить
            //mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        mediaPlayer.stop();*/

        repeatOne = true;

    }

    public void playQueue(ArrayList<Verse> objects, RecyclerView recyclerView,
                          MediaPlayer mediaPlayer, ImageButton playBtn,
                          int drawablePlay, int drawablePause, int startPosition) {
        startPosition = recyclerView.getChildAdapterPosition(recyclerView);
        for (int i = startPosition; i < objects.size() - 1; ++i) {
            recyclerView.scrollToPosition(i);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mediaPlayer.start();
                    playBtn.setImageResource(drawablePlay);
                    if (timer.purge() != mediaPlayer.getDuration()) {
                        mediaPlayer.stop();
                        playBtn.setImageResource(drawablePause);
                    }
                }
            }, mediaPlayer.getDuration());
        }
    }

    private void updateSeekBar() {
        if (seekBar != null) {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            if (mediaPlayer.isPlaying()) {
                Runnable runnable = this::updateSeekBar;
                seekBar.postDelayed(runnable, 1000);
            }
        }
    }

    public void onComplete(ImageButton imageButton, int drawable) {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (!repeatOne) imageButton.setImageResource(drawable);
                else mediaPlayer.setLooping(true);
            }
        });
    }

}


package com.example.tabiin.objects.sures;

import android.media.MediaPlayer;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Verse {
    private String text;
    private String audioLink;
    private int number;

    private ImageButton play;

    private MediaPlayer mediaPlayer;

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public String getText() {
        return text;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Verse{" +
                "text='" + text + '\'' +
                ", audioLink='" + audioLink + '\'' +
                '}';
    }

    public static String toStr(ArrayList<Verse> verses){
        String str = "";
        for (Verse verse:
             verses) {
            str.concat(verse.getText());
        }
        return str;
    }
}
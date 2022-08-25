package com.example.tabiin.objects.sures;

import java.util.ArrayList;

public class Verse {
    private String text;
    private String audioLink;

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
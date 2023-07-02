package com.example.tabiin.objects.sures;

import java.util.ArrayList;

public class Sura {
    private String name;
    private String translated_name;

    private String foreword;
    private String translated_foreword;

    private ArrayList<Verse> verses;
    private ArrayList<Verse> translated_verses;

    private ArrayList<Verse> audioLinks;

    public String getName() {
        return name;
    }

    public String getTranslatedName() {
        return translated_name;
    }

    public String getForeword() {
        return foreword;
    }

    public String getTranslatedForeword() {
        return translated_foreword;
    }

    public ArrayList<Verse> getVerses() {
        return verses;
    }

    public ArrayList<Verse> getTranslatedVerses() {
        return translated_verses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTranslatedName(String translatedName) {
        this.translated_name = translatedName;
    }

    public void setForeword(String foreword) {
        this.foreword = foreword;
    }

    public void setTranslatedForeword(String translatedForeword) {
        this.translated_foreword = translatedForeword;
    }

    public void setVerses(ArrayList<Verse> verses) {
        this.verses = verses;
    }

    public void setTranslatedVerses(ArrayList<Verse> translatedVerses) {
        this.translated_verses = translatedVerses;
    }

    public ArrayList<Verse> getAudioLinks() {
        return audioLinks;
    }

    public void setAudioLinks(ArrayList<Verse> audioLinks) {
        this.audioLinks = audioLinks;
    }

    @Override
    public String toString() {
        return "Sura{" +
                "name='" + name + '\'' +
                ", translatedName='" + translated_name + '\'' +
                ", foreword='" + foreword + '\'' +
                ", translatedForeword='" + translated_foreword + '\'' +
                ", verses=" + verses +
                ", translatedVerses=" + translated_verses +
                '}';
    }
}
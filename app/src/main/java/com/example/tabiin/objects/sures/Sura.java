package com.example.tabiin.objects.sures;

import java.util.ArrayList;

public class Sura {
    private String name;
    private String translatedName;

    private String foreword;
    private String translatedForeword;

    private ArrayList<Verse> verses;
    private ArrayList<Verse> translatedVerses;

    public String getName() {
        return name;
    }

    public String getTranslatedName() {
        return translatedName;
    }

    public String getForeword() {
        return foreword;
    }

    public String getTranslatedForeword() {
        return translatedForeword;
    }

    public ArrayList<Verse> getVerses() {
        return verses;
    }

    public ArrayList<Verse> getTranslatedVerses() {
        return translatedVerses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTranslatedName(String translatedName) {
        this.translatedName = translatedName;
    }

    public void setForeword(String foreword) {
        this.foreword = foreword;
    }

    public void setTranslatedForeword(String translatedForeword) {
        this.translatedForeword = translatedForeword;
    }

    public void setVerses(ArrayList<Verse> verses) {
        this.verses = verses;
    }

    public void setTranslatedVerses(ArrayList<Verse> translatedVerses) {
        this.translatedVerses = translatedVerses;
    }
}
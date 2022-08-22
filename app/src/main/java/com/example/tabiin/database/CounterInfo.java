package com.example.tabiin.database;

import android.widget.ProgressBar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CounterInfo {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title")
    public String title; // Название цели

    @ColumnInfo(name = "descript")
    public String descript; // Описание цели

    @ColumnInfo(name = "tsel")
    public int tsel; // Цель

    @ColumnInfo(name = "progressInt")
    public int progressInt;  // Прогресс (число)

    @ColumnInfo(name = "ItemId")
    public int itemId;

    @ColumnInfo(name = "textProgress")
    public String textProgress; // TextView для отображения прогресса

    @ColumnInfo(name = "complete")
    public boolean complete; // Завершена или не завершена цель

}

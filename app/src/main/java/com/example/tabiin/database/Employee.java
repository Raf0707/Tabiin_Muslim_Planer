package com.example.tabiin.database;

import android.widget.ProgressBar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

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

    @ColumnInfo(name = "EmployeeId")
    public int eId;

    @ColumnInfo(name = "currentProgress")
    public ProgressBar currentProgress; // Прогресс (ПрогрессБар)

    @ColumnInfo(name = "textProgress")
    public String textProgress; // TextView для отображения прогресса

    @ColumnInfo(name = "complete")
    public boolean complete; // Завершена или не завершена цель

}

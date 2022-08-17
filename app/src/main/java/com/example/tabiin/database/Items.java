package com.example.tabiin.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Items {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "empId")
    public int empId;

    @ColumnInfo(name = "itemName")
    public String itemName;
}

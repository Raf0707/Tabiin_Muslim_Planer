package com.example.tabiin.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CounterItems {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "counterItemId")
    public int empId;

    @ColumnInfo(name = "itemName")
    public String itemName;
}

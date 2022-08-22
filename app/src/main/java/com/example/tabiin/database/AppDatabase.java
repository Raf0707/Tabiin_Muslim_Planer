package com.example.tabiin.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tabiin.dao.ItemDao;

@Database(entities = {CounterInfo.class, CounterItems.class},  version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
    public static AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "AppDataBase")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }
}



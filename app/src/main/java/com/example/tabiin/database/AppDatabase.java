package com.example.tabiin.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tabiin.dao.EmployeeDao;

@Database(entities = {Employee.class, Items.class},  version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
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



package com.example.tabiin.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tabiin.database.CounterInfo;
import com.example.tabiin.database.CounterItems;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("Select * from CounterItems")
    List<CounterItems> getAllCounterItems();

    @Insert
    void insertCounterItem(CounterItems... counterItems);

    @Update
    void updateCounterItem(CounterItems counterItems);

    @Delete
    void deleteCounterItem(CounterItems counterItems);

//    @Query("Select * from CounterItems where counterItemId=:itemId")
//    List<CounterInfo> getAllCounterItemsList(int itemId);

    @Insert
    void insertCounterInfo(CounterInfo counterInfo);

    @Update
    void updateCounterInfo(CounterInfo counterInfo);

    @Delete
    void deleteCounterInfo(CounterInfo counterInfo);

}

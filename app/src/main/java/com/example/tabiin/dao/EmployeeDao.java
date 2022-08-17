package com.example.tabiin.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tabiin.database.Employee;
import com.example.tabiin.database.Items;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM items")
    List<Employee> getAllEmpItems();

    @Query("SELECT * FROM employee")
    List<Employee> getAllEmployee();

    @Query("SELECT * FROM items WHERE itemName = :id")
    Employee getItemById(long id);

    @Query("SELECT * FROM employee WHERE title = :id")
    Employee getEmpById(long id);

    @Query("Select * from Items where empId = :catId")
    List<Items> getAllEmpItems(int catId);

    @Insert
    void insert(Items employees);

    @Update
    void update(Employee employee);

    @Delete
    void deleteEmp(Employee employee);

    @Delete
    void deleteItem(Items items);
}

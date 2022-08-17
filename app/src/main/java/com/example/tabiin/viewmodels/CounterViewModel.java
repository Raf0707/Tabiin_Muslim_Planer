package com.example.tabiin.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tabiin.database.AppDatabase;
import com.example.tabiin.database.Employee;
import com.example.tabiin.database.Items;

import java.util.List;

public class CounterViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;
    private MutableLiveData<List<Employee>> listItem;

    public CounterViewModel(Application application) {
        super(application);
        listItem = new MutableLiveData<>();

        appDatabase = AppDatabase.getInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Employee>> getItemListObsever() {
        return listItem;
    }

    public void getAllListItems() {
        List<Employee> items = appDatabase.employeeDao().getAllEmpItems();
        if (items.size() > 0) {
            listItem.postValue(items);
        } else {
            listItem.postValue(null);
        }
    }

    public void insertItem(String itemName) {
        Items items = new Items();
        items.itemName = itemName;
        appDatabase.employeeDao().insert(items);
        getAllListItems();
    }

    public void updateItem(Items items) {
        appDatabase.employeeDao().insert(items);
        getAllListItems();
    }

    public void deleteItem(Items items) {
        appDatabase.employeeDao().deleteItem(items);
        getAllListItems();
    }


}

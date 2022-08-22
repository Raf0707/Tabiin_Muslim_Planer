package com.example.tabiin.viewmodels.counter;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tabiin.database.AppDatabase;
import com.example.tabiin.database.CounterItems;

import java.util.List;

public class CounterViewModel extends AndroidViewModel {

    private MutableLiveData<List<CounterItems>> itemsOfCounterList;
    AppDatabase appDatabase;

    public CounterViewModel(@NonNull Application application) {
        super(application);
        itemsOfCounterList = new MutableLiveData<>();

        appDatabase = AppDatabase.getInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<CounterItems>> getCounterItemsListObserver() {
        return itemsOfCounterList;
    }

    public void getAllCounterItemsList() {
        List<CounterItems> counterItemsList = appDatabase.itemDao().getAllCounterItems();

        if (counterItemsList.size() > 0) {
            itemsOfCounterList.postValue(counterItemsList);
        } else {
            itemsOfCounterList.postValue(null);
        }
    }

    public void insertCounterItems(String itemName) {
        CounterItems counterItems = new CounterItems();
        counterItems.itemName = itemName;
        appDatabase.itemDao().insertCounterItem(counterItems);
        getAllCounterItemsList();
    }

    public void updateCounterItems(CounterItems counterItems) {
        appDatabase.itemDao().updateCounterItem(counterItems);
        getAllCounterItemsList();
    }

    public void deleteCounterItems(CounterItems counterItems) {
        appDatabase.itemDao().deleteCounterItem(counterItems);
        getAllCounterItemsList();
    }

}

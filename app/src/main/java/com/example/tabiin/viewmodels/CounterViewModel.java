package com.example.tabiin.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.tabiin.domain.models.counter.Counter;

import java.util.HashMap;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<HashMap<String, Counter>> counterLiveData = new MutableLiveData<>();

    public LiveData<HashMap<String,Counter>> getCounterLiveData(){
        return counterLiveData;
    }

    public Counter getCounterByTitle(String title){
        return counterLiveData.getValue().get(title);
    }

    public void updateCounterTitle(String title){
        HashMap<String, Counter> map = counterLiveData.getValue();
        map.get(title).setTitle(title);
        counterLiveData.setValue(map);
    }

    public void updateCounterDescription(String title, String description){
        HashMap<String, Counter> map = counterLiveData.getValue();
        map.get(title).setDescription(description);
        counterLiveData.setValue(map);
    }

    public void updateCounterAim(String title, int aim){
        HashMap<String, Counter> map = counterLiveData.getValue();
        map.get(title).setAim(aim);
        counterLiveData.setValue(map);
    }

    public void updateCounterProgress(String title, int progress){
        HashMap<String, Counter> map = counterLiveData.getValue();
        map.get(title).setCurrentProgress(progress);
        counterLiveData.setValue(map);
    }
}

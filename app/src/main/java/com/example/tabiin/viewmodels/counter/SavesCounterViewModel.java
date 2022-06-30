package com.example.tabiin.viewmodels.counter;

import androidx.lifecycle.*;
import androidx.lifecycle.ViewModel;

import com.example.tabiin.domain.models.counter.*;

import java.util.*;

public class SavesCounterViewModel extends ViewModel {
    private MutableLiveData<HashMap<String, Counter>> savesCounterLiveData = new MutableLiveData<>();
    public LiveData<HashMap<String,Counter>> getSavesCounterLiveData(){ return savesCounterLiveData; }
    public Counter getSavesCounterByTitle(String title){ return savesCounterLiveData.getValue().get(title); }
}

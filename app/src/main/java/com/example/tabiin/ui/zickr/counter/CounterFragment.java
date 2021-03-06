package com.example.tabiin.ui.zickr.counter;

import android.os.Bundle;

import android.widget.*;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.*;

import com.example.tabiin.R;
import com.example.tabiin.viewmodels.counter.CounterViewModel;


public class CounterFragment extends Fragment implements View.OnClickListener{
    private EditText etTitleDescript;
    private EditText etTitleTsel;
    private EditText etTsel;

    private Button back;
    private Button saveProgress;
    private Button resetProgress;
    private Button setCounter;
    private Button plus;
    private Button minus;
    private Button editTsel;

    private ProgressBar mainProgressBar;

    private TextView editProgressCount;

    private String selectedCounterTitle;

    private CounterViewModel counterViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_counter, container, false);

        etTitleTsel = view.findViewById(R.id.titleTsel);
        etTsel = view.findViewById(R.id.tsel);
        etTitleDescript = view.findViewById(R.id.titleDescript);

        back = view.findViewById(R.id.back);
        saveProgress = view.findViewById(R.id.saveProgressCounterFragment);
        resetProgress = view.findViewById(R.id.resetProgressCounterFragment);
        editProgressCount = view.findViewById(R.id.editProgressCountTextCounterFragment);
        setCounter = view.findViewById(R.id.setCounter);
        plus = view.findViewById(R.id.plusCounterFragment);
        minus = view.findViewById(R.id.minusCounterFragment);
        editProgressCount = view.findViewById(R.id.editProgressCountTextCounterFragment);

        mainProgressBar = view.findViewById(R.id.mainProgressBarCounterFragment);

        // Кнопка с карандашом
        // карандаш, кнопка для изменения данных счетчика в интерфейсе и БД
        editTsel = view.findViewById(R.id.editTselCounterFragment);

        // editProgressCount.setBackground(getContext().getResources().getDrawable(contur_45));

        back.setOnClickListener(this);
        saveProgress.setOnClickListener(this);
        editTsel.setOnClickListener(this);
        resetProgress.setOnClickListener(this);
        setCounter.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);

        counterViewModel = new CounterViewModel();
        // counterViewModel.getCounterLiveData().observe(this, new Observer<HashMap<String, Counter>>() {
        counterViewModel.getCounterLiveData().observe((LifecycleOwner) getContext(), map -> {
            etTitleTsel.setText(map.get(selectedCounterTitle).getTitle());
            etTsel.setText(map.get(selectedCounterTitle).getAim());
            etTitleDescript.setText(map.get(selectedCounterTitle).getDescription());

            mainProgressBar.setProgress(map.get(selectedCounterTitle).getCurrentProgress());

            // editProgress - TextView, которое наложено на mainProgressBar
            // показывает текущий прогресс на mainProgressBar
            // Наложенное TextView
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.plusCounterFragment:
                counterViewModel.updateCounterProgress(selectedCounterTitle,
                        counterViewModel.getCounterByTitle(selectedCounterTitle).getCurrentProgress()+1);
                break;
            case R.id.minusCounterFragment:
                counterViewModel.updateCounterProgress(selectedCounterTitle,
                        counterViewModel.getCounterByTitle(selectedCounterTitle).getCurrentProgress()-1);
                break;
            case R.id.back: break;
            case R.id.resetProgressCounterFragment:
                counterViewModel.updateCounterProgress(selectedCounterTitle,0);
                break;
            case R.id.saveProgressCounterFragment: break;
            case R.id.editTselCounterFragment: break;
            
        }
    }
}
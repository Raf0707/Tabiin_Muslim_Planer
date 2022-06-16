package com.example.tabiin.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.google.android.material.floatingactionbutton.*;


public class CounterSavesFragment extends Fragment implements View.OnClickListener {

    private RecyclerView savesList;
    private FloatingActionButton addCounter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter_saves, container, false);

        savesList = view.findViewById(R.id.recycleCounter);
        addCounter = view.findViewById(R.id.fabAddCounter);
        addCounter.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
package com.example.tabiin.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.*;
import com.example.tabiin.ui.zickr.*;


public class NavigationFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        switch (MainActivity.SelectFragment) {
            case 1:
                //getSupportFragmentManager()
                getFragmentManager().beginTransaction().replace(R.id.navigationLayout, new GeneralZickrFragment()).commit();
                break;
        }

        return view;
    }


}
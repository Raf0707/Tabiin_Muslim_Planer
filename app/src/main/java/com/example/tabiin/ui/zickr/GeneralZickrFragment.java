package com.example.tabiin.ui.zickr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.google.android.material.card.MaterialCardView;


public class GeneralZickrFragment extends Fragment {
    private MaterialCardView materialCardCounter;
    private MaterialCardView materialCardGestureCounter;
    private MaterialCardView materialCardSalavat;
    private MaterialCardView materialCardAlahNames;
    private MaterialCardView materialCardDailyDua;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general_zickr, container, false);
        return view;
    }
}
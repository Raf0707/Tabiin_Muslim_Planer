package com.example.tabiin.ui.zickr.gesture_counter.general_screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentGestureCounterBinding;

public class GestureCounterFragment extends Fragment {

    private FragmentGestureCounterBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGestureCounterBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
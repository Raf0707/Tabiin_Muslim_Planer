package com.example.tabiin.ui.zickr;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentGeneralZickrBinding;
import com.example.tabiin.ui.about_app.AppAboutFragment;
import com.example.tabiin.ui.zickr.athcar.AthcarFragment;
import com.example.tabiin.ui.zickr.counter.CounterFragment;
import com.example.tabiin.ui.zickr.dua.DuaFragment;
import com.example.tabiin.ui.zickr.gesture_counter.general_screen.GestureCounterFragment;
import com.example.tabiin.ui.zickr.names.AllahNamesFragment;
import com.example.tabiin.ui.zickr.salavat.SalavatFragment;



public class GeneralZickrFragment extends Fragment {
    FragmentGeneralZickrBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeneralZickrBinding
                .inflate(inflater, container, false);

        binding.materialCardCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new CounterFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        binding.materialCardGestureCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new GestureCounterFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        binding.materialCardSalavat.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new SalavatFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        binding.materialCardAllahNames.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new AllahNamesFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        binding.materialCardDailyDua.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new DuaFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        binding.materialCardOtherZickr.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new AthcarFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        return binding.getRoot();
    }
}
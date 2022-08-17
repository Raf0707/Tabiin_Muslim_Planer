package com.example.tabiin.ui.zickr.counter.counter_settings.general_screen;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentCounterSettingsBinding;
import com.example.tabiin.ui.zickr.counter.CounterFragment;
import com.example.tabiin.ui.zickr.counter.counter_settings.settings_counter.GeneralCounterSettingsFragment;
import com.example.tabiin.ui.zickr.counter.counter_settings.settings_counter.click_counter.ClickCounterSettingsFragment;


public class CounterSettingsFragment extends Fragment {
    private FragmentCounterSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCounterSettingsBinding
                .inflate(inflater, container, false);


        binding.titleOneClickSet.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new ClickCounterSettingsFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });


        binding.titleOneClickGeneral.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new GeneralCounterSettingsFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        binding.backCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new CounterFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        return binding.getRoot();
    }
}
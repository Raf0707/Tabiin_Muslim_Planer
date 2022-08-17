package com.example.tabiin.ui.zickr.counter.counter_settings.settings_counter.click_counter;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentClickCounterSettingsBinding;
import com.example.tabiin.ui.zickr.counter.counter_settings.general_screen.CounterSettingsFragment;


public class ClickCounterSettingsFragment extends Fragment {
    private FragmentClickCounterSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClickCounterSettingsBinding
                .inflate(inflater, container, false);

        binding.backSettingsCounterFromClickSettings.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new CounterSettingsFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        return binding.getRoot();
    }
}
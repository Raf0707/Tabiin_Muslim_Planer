package com.example.tabiin.ui.zickr.gesture_counter.settings;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentGestureCounterSettingsBinding;
import com.example.tabiin.databinding.FragmentSettingsBetaCounterBinding;
import com.example.tabiin.ui.zickr.gesture_counter.general_screen.GestureCounterFragment;
import com.example.tabiin.ui.zickr.gesture_counter_beta.general_screen.GeneralBetaGestureCounterFragment;


public class GestureCounterSettingsFragment extends Fragment {

    private FragmentGestureCounterSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGestureCounterSettingsBinding.inflate(inflater, container, false);

        binding.backGestureCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new GestureCounterFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        return binding.getRoot();
    }
}
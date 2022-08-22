package com.example.tabiin.ui.zickr.gesture_counter_beta.settings_beta;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentSettingsBetaCounterBinding;
import com.example.tabiin.ui.zickr.gesture_counter_beta.general_screen.GeneralBetaGestureCounterFragment;


public class SettingsBetaCounterFragment extends Fragment {
    private FragmentSettingsBetaCounterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSettingsBetaCounterBinding.inflate(inflater, container, false);

        binding.backBetaCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new GeneralBetaGestureCounterFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        return binding.getRoot();
    }
}
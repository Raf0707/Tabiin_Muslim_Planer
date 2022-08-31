package com.example.tabiin.ui.kitab;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentGeneralKitabihilBinding;
import com.example.tabiin.databinding.FragmentGeneralZickrBinding;
import com.example.tabiin.ui.kitab.quran.QuranFragment;
import com.example.tabiin.ui.kitab.quran_rtx.main_quran.MainQuranFragment;
import com.example.tabiin.ui.zickr.counter.CounterFragment;


public class GeneralKitabihilFragment extends Fragment {
    private FragmentGeneralKitabihilBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeneralKitabihilBinding
                .inflate(inflater, container, false);

        binding.materialCardQuran.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new MainQuranFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        return binding.getRoot();
    }
}
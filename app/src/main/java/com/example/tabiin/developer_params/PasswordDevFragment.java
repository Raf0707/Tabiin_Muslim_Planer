package com.example.tabiin.developer_params;

import static com.example.tabiin.util.UtilFragment.changeFragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentPasswordDevBinding;
import com.example.tabiin.ui.about_app.AppAboutFragment;
import com.google.android.material.snackbar.Snackbar;

public class PasswordDevFragment extends Fragment {
    FragmentPasswordDevBinding devBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        devBinding = FragmentPasswordDevBinding
                .inflate(inflater, container, false);

        devBinding.passSet.setOnClickListener(view -> {
            try {

                if (Integer.parseInt(devBinding.devPass.getText().toString()) == 997394) {

                    changeFragment(requireActivity(),
                            new DeveloperParamsFragment(),
                            R.id.kontainerFragment, savedInstanceState);

                } else {
                    goBack();
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                goBack();
            }
        });

        return devBinding.getRoot();
    }

    public void goBack() {
        Snackbar.make(requireView(),
                new StringBuilder()
                        .append("Неверный пароль!")
                        .toString(),

                Snackbar.LENGTH_LONG).show();

        changeFragment(requireActivity(),
                new AppAboutFragment(),
                R.id.kontainerFragment, null);
    }
}
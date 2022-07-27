package com.example.tabiin.developer_params;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentDeveloperParamsBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;


public class DeveloperParamsFragment extends Fragment {
    private FragmentDeveloperParamsBinding bind;
    private long startTimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = FragmentDeveloperParamsBinding.inflate(inflater, container, false);

        bind.sincNow.setOnClickListener(view -> Snackbar.make(requireView(),
                "Gradle build finished in " +
                        ThreadLocalRandom.current().nextInt(12, 561) + " ms",
                Snackbar.LENGTH_LONG).show());

        bind.restartNow.setOnClickListener(view -> Snackbar.make(requireView(),
                "Changes Apply Sucscessfully!", Snackbar.LENGTH_LONG).show());

        bind.debugNow.setOnClickListener(view -> Snackbar.make(requireView(),
                "Android App Tabiin finished  Debug in " +
                        ThreadLocalRandom.current().nextInt(132, 834) + " ms",
                Snackbar.LENGTH_LONG).show());

        return bind.getRoot();
    }
}
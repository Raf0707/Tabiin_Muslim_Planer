package com.example.tabiin.developer_params;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = FragmentDeveloperParamsBinding.inflate(inflater, container, false);

        bind.sincNow.setOnClickListener(view -> {
            Snackbar.make(requireView(),
                    new StringBuilder()
                            .append(getString(R.string.Gradle_build))
                            .append(ThreadLocalRandom.current().nextInt(12, 561))
                            .append(getString(R.string.Milly_sec))
                            .toString(),

                    Snackbar.LENGTH_LONG).show();
        });

        bind.restartNow.setOnClickListener(view -> Snackbar.make(requireView(),
                R.string.Apply_changes, Snackbar.LENGTH_LONG).show());

        bind.debugNow.setOnClickListener(view -> Snackbar.make(requireView(),
                new StringBuilder()
                        .append(getString(R.string.Debug_finish))
                        .append(ThreadLocalRandom.current().nextInt(132, 834))
                        .append(getString(R.string.Milly_sec))
                        .toString(),

                Snackbar.LENGTH_LONG).show());

        return bind.getRoot();
    }
}
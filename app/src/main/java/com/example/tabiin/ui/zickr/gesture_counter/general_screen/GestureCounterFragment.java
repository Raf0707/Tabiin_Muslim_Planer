package com.example.tabiin.ui.zickr.gesture_counter.general_screen;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentGestureCounterBinding;
import com.example.tabiin.ui.zickr.gesture_counter.settings.GestureCounterSettingsFragment;
import com.example.tabiin.ui.zickr.gesture_counter_beta.general_screen.GeneralBetaGestureCounterFragment;
import com.example.tabiin.util.OnSwipeTouchListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.concurrent.TimeUnit;

public class GestureCounterFragment extends Fragment {

    private FragmentGestureCounterBinding binding;
    private Handler handler;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGestureCounterBinding
                .inflate(inflater, container, false);

        handler = new Handler();

        binding.settingsGestureCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new GestureCounterSettingsFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        binding.counterGestureView.setOnTouchListener(
                new OnSwipeTouchListener(
                        binding.counterGestureView.getContext()) {

                    @Override
                    public void onClick() {
                        counter++;
                        binding.gestureCounter.setText(Integer.toString(counter));
                    }

                    @Override
                    public void onSwipeDown() {
                        counter--;
                        binding.gestureCounter.setText(Integer.toString(counter));
                    }

                    @Override
                    public void onLongClick() {
                        if (counter != 0 &&
                                binding.gestureCounter.getText().toString() != "0")
                            onMaterialAlert();
                    }

                });

        Thread t = new Thread(() -> {
            try{
                TimeUnit.MILLISECONDS.sleep(100);
                handler.post(r);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        return binding.getRoot();
    }

    Runnable r = new Runnable() {
        public void run(){
            binding.gestureCounter.setText(Integer.toString(counter));
            handler.postDelayed(r,100);
        }
    };

    public void onMaterialAlert() {
        new MaterialAlertDialogBuilder(requireContext(),
                R.style.AlertDialogTheme)
                .setTitle("Reset")
                .setMessage("Вы уверены, что хотите обновить счетчик?")
                .setPositiveButton("Да", (dialogInterface, i) -> {
                    counter = 0;
                    binding.gestureCounter
                            .setText(new StringBuilder()
                                    .append("0"));
                })
                .setNeutralButton("Отмена",
                        (dialogInterface, i) ->
                                dialogInterface.cancel())
                .show();
    }
}
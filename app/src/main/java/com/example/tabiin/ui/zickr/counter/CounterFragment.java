package com.example.tabiin.ui.zickr.counter;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentCounterBinding;
import com.example.tabiin.util.CallBack;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class CounterFragment extends Fragment {
    private FragmentCounterBinding binding;
    private int currentCount;
    private String defoltValue = "10";
    private int maxvalue;
    private SharedPreferences sPreff;
    private Handler handler;

    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator(2);
    private static final long GAUGE_ANIMATION_DURATION = 10;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCounterBinding
                .inflate(inflater, container, false);

        handler = new Handler();

        binding.saveProgressCounterFragment.setOnClickListener(view -> {
            // saveText()
            binding.tsel.setText(binding
                    .tsel
                    .getText()
                    .toString()
                    .replaceAll("[\\.\\-,\\s]+", ""));

            binding.tsel.setCursorVisible(false);
            binding.tsel.setFocusableInTouchMode(false);
            binding.tsel.setEnabled(false);

            binding.titleTsel.setCursorVisible(false);
            binding.titleTsel.setFocusableInTouchMode(false);
            binding.titleTsel.setEnabled(false);

            binding.titleDescript.setCursorVisible(false);
            binding.titleDescript.setFocusableInTouchMode(false);
            binding.titleDescript.setEnabled(false);

            if (binding.tsel.getText().toString().length() == 0) {
                binding.tsel.setText(defoltValue);
                maxvalue = Integer.parseInt(binding
                        .tsel
                        .getText()
                        .toString());

                binding.mainProgressBarCounterFragment.setMax(maxvalue);

                Snackbar.make(requireView(),
                        new StringBuilder()
                                .append("Вы не ввели цель. По умолчанию: ")
                                .append(defoltValue),
                        Snackbar.LENGTH_LONG)
                        .show();

            } else {

                if (Integer.parseInt(binding.tsel.getText().toString()) <= 0) {
                    Snackbar.make(requireView(),
                            new StringBuilder()
                                    .append("Введите число больше нуля!"),
                            Snackbar.LENGTH_LONG)
                            .show();

                } else {

                    Snackbar.make(requireView(),
                            new StringBuilder()
                                    .append("Цель установлена"),
                            Snackbar.LENGTH_LONG)
                            .show();

                    maxvalue = Integer.parseInt(binding.tsel.getText().toString());
                    binding.mainProgressBarCounterFragment.setMax(maxvalue);
                    binding
                            .editProgressCountTextCounterFragment
                            .setText(MessageFormat
                                    .format("{0} / {1}",
                                            currentCount,
                                            binding
                                                    .tsel
                                                    .getText()
                                                    .toString()));

                }
            }

        });

        binding.editTselCounterFragment.setOnClickListener(view -> {

            binding.tsel.setCursorVisible(true);
            binding.tsel.setFocusableInTouchMode(true);
            binding.tsel.setEnabled(true);

            binding.titleTsel.setCursorVisible(true);
            binding.titleTsel.setFocusableInTouchMode(true);
            binding.titleTsel.setEnabled(true);

            binding.tsel.requestFocus();

            binding.tsel.setSelection(
                    binding.tsel.getText().length()
            );

            getActivity()
                    .getWindow()
                    .setFlags(WindowManager
                            .LayoutParams
                            .FLAG_NOT_FOCUSABLE,
                            WindowManager
                                    .LayoutParams
                                    .FLAG_ALT_FOCUSABLE_IM
                    );

            getActivity()
                    .getWindow()
                    .setSoftInputMode(
                            WindowManager
                                    .LayoutParams
                                    .SOFT_INPUT_STATE_VISIBLE
                    );

            getContext()
                    .getSystemService(Context
                            .INPUT_METHOD_SERVICE);

            InputMethodManager imm = (InputMethodManager) getActivity()
                    .getSystemService(Context
                            .INPUT_METHOD_SERVICE);

            if (imm != null) {
                imm.showSoftInput(binding.tsel,
                        InputMethodManager.SHOW_FORCED);
            }

        });

        binding.plusCounterFragment.setOnClickListener(view -> {
            //saveText();
            if (binding.tsel.getText().toString().length() == 0) {
                maxvalue = 100;
                binding.tsel.setText(Integer.toString(maxvalue));
                binding.mainProgressBarCounterFragment.setMax(100);
                binding.editProgressCountTextCounterFragment
                        .setText(MessageFormat.format("{0} / {1}",
                                currentCount, 100));
            }
            if (currentCount == maxvalue) {
                binding.editProgressCountTextCounterFragment
                        .setText(MessageFormat
                                .format("{0} / {1}",
                        binding.tsel
                                .getText()
                                .toString(),
                                binding.tsel
                                        .getText()
                                        .toString()));

                Snackbar.make(requireView(),
                                new StringBuilder()
                                        .append("Цель достигнута! Да вознаградит вас Аллах!"),
                                Snackbar.LENGTH_LONG)
                        .show();
            }

            if (binding.tsel.getText().toString() != null) {
                currentCount++;
                if (currentCount <= Integer
                        .parseInt(binding.tsel
                                .getText()
                                .toString())) {
                    binding.editProgressCountTextCounterFragment
                            .setText(MessageFormat
                                    .format("{0} / {1}", currentCount,
                            binding.tsel.getText().toString()));
                }

                ObjectAnimator animator = ObjectAnimator
                        .ofInt(binding.mainProgressBarCounterFragment,
                                "progress",
                        currentCount, currentCount);

                animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                animator.setDuration(GAUGE_ANIMATION_DURATION);
                animator.start();


                if (binding.tsel.length() != 0) {
                    maxvalue = Integer.parseInt(binding.tsel.getText().toString());

                    if (currentCount == maxvalue) {
                        Snackbar.make(requireView(),
                                        new StringBuilder()
                                                .append("Цель достигнута! " +
                                                        "Да вознаградит вас Аллах!"),
                                        Snackbar.LENGTH_LONG)
                                .show();

                    }

                }

            }


            else {
                Snackbar.make(requireView(),
                                new StringBuilder()
                                        .append("Введите цель!"),
                                Snackbar.LENGTH_LONG)
                        .show();
            }

            //saveText();
            //loadText();
            
        });
        
        binding.minusCounterFragment.setOnClickListener(view -> {
            //saveText();
            currentCount--;
            if (currentCount < 0) {
                currentCount = 0;
            }

            if (binding.tsel
                    .getText()
                    .toString()
                    .length() == 0) {
                binding.editProgressCountTextCounterFragment
                        .setText(MessageFormat.format("{0} / {1}",
                                currentCount, 100));
            } else if (currentCount <= Integer
                    .parseInt(binding.tsel
                            .getText()
                            .toString())) {
                binding.editProgressCountTextCounterFragment
                        .setText(MessageFormat
                                .format("{0} / {1}",
                                        currentCount, binding.tsel
                                                .getText()
                                                .toString()));

            }

            ObjectAnimator animatorMinus = ObjectAnimator
                    .ofInt(binding.mainProgressBarCounterFragment,
                            "progress",
                            currentCount, currentCount);

            animatorMinus.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
            animatorMinus.setDuration(GAUGE_ANIMATION_DURATION);
            animatorMinus.start();

            //saveText();
            //loadText();

        });

        binding.resetProgressCounterFragment.setOnClickListener(view -> {
            //saveText();
            if (currentCount != 0) onMaterialAlert();
            //saveText();
            //loadText();

        });

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                handler.post(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        return binding.getRoot();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            CallBack.runAllCallbacks();
            handler.postDelayed(runnable, 100);
        }
    };

    public void onMaterialAlert() {
        new MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
                .setTitle("Reset")
                .setMessage("Вы уверены, что хотите обновить счетчик?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        currentCount = 0;
                        binding.editProgressCountTextCounterFragment
                                .setText(new StringBuilder()
                                        .append("0 / ")
                                        .append(binding.tsel
                                                .getText()
                                                .toString())
                                        .toString());

                        ObjectAnimator animatorMaterial = ObjectAnimator
                                .ofInt(binding.mainProgressBarCounterFragment,
                                        "progress", currentCount);
                        animatorMaterial.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                        animatorMaterial.setDuration(GAUGE_ANIMATION_DURATION);
                        animatorMaterial.start();
                    }
                })
                .setNeutralButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }

}

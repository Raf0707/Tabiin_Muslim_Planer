package com.example.tabiin.ui.zickr.gesture_counter_beta.general_screen;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentGeneralBetaGestureCounterBinding;
import com.example.tabiin.ui.zickr.counter.counter_settings.general_screen.CounterSettingsFragment;
import com.example.tabiin.ui.zickr.gesture_counter_beta.settings_beta.SettingsBetaCounterFragment;
import com.example.tabiin.util.CallBack;
import com.example.tabiin.util.OnSwipeTouchListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

public class GeneralBetaGestureCounterFragment extends Fragment {
    private FragmentGeneralBetaGestureCounterBinding binding;
    private int currentCount;
    private String defoltValue = "100";
    private int maxvalue;
    private SharedPreferences sPreff;
    private Handler handler;

    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR =
            new DecelerateInterpolator(2);

    private static final long GAUGE_ANIMATION_DURATION = 10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGeneralBetaGestureCounterBinding
                .inflate(inflater, container, false);

        handler = new Handler();

        binding.tselBeta.setCursorVisible(true);
        binding.tselBeta.setFocusableInTouchMode(true);
        binding.tselBeta.setEnabled(true);

        binding.saveBetaCounter.setOnClickListener(view -> {
            binding.tselBeta.setText(
                    binding.tselBeta
                            .getText()
                            .toString()
                            .replaceAll("[\\.\\-,\\s]+", ""));

            binding.tselBeta.setCursorVisible(false);
            binding.tselBeta.setFocusableInTouchMode(false);
            binding.tselBeta.setEnabled(false);

            if (binding.tselBeta.getText().toString().length() == 0) {
                binding.tselBeta.setText(defoltValue);
                maxvalue = Integer.parseInt(binding
                        .tselBeta
                        .getText()
                        .toString());

                binding.counterBetaProgress.setMax(maxvalue);

                Snackbar.make(requireView(),
                                new StringBuilder()
                                        .append("Вы не ввели цель. По умолчанию: ")
                                        .append(defoltValue),
                                Snackbar.LENGTH_LONG)
                        .show();

            } else {

                if (Integer.parseInt(binding.tselBeta.getText().toString()) <= 0) {
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

                    maxvalue = Integer.parseInt(binding.tselBeta.getText().toString());
                    binding.counterBetaProgress.setMax(maxvalue);
                    binding
                            .textBetaProgress
                            .setText(MessageFormat
                                    .format("{0}",
                                            currentCount));

                }
            }

        });

        binding.editBetaCounter.setOnClickListener(view -> {
            binding.tselBeta.setCursorVisible(true);
            binding.tselBeta.setFocusableInTouchMode(true);
            binding.tselBeta.setEnabled(true);

            binding.tselBeta.requestFocus();

            binding.tselBeta.setSelection(
                    binding.tselBeta.getText().length()
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
                imm.showSoftInput(binding.tselBeta,
                        InputMethodManager.SHOW_FORCED);
            }
        });

        binding.deleteBetaCounter.setOnClickListener(view -> {
            binding.tselBeta.getText().clear();
        });

        binding.counterBetaView.setOnTouchListener
                (new OnSwipeTouchListener(binding
                        .counterBetaView.getContext()) {

                    @Override
                    public void onClick() {
//                        currentCount++;
//                        binding.textBetaProgress
//                                .setText(Integer.toString(currentCount));

                        if (binding.tselBeta.getText().toString().length() == 0) {
                            maxvalue = 100;
                            binding.tselBeta.setText(Integer.toString(maxvalue));
                            binding.counterBetaProgress.setMax(100);
                            binding.textBetaProgress
                                    .setText(MessageFormat.format("{0}",
                                            currentCount));
                        }
                        if (currentCount == maxvalue) {
                            binding.textBetaProgress
                                    .setText(MessageFormat
                                            .format("{0}",
                                                    binding.tselBeta
                                                            .getText()
                                                            .toString()));

                            Snackbar.make(requireView(),
                                            new StringBuilder()
                                                    .append("Цель достигнута! " +
                                                            "Да вознаградит вас Аллах!"),
                                            Snackbar.LENGTH_LONG)
                                    .show();
                        }

                        if (binding.tselBeta.getText().toString() != null) {
                            currentCount++;
                            if (currentCount <= Integer
                                    .parseInt(binding.tselBeta
                                            .getText()
                                            .toString())) {
                                binding.textBetaProgress
                                        .setText(MessageFormat
                                                .format("{0}", currentCount));
                            }

                            ObjectAnimator animator = ObjectAnimator
                                    .ofInt(binding.counterBetaProgress,
                                            "progress",
                                            currentCount, currentCount);

                            animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                            animator.setDuration(GAUGE_ANIMATION_DURATION);
                            animator.start();


                            if (binding.tselBeta.length() != 0) {
                                maxvalue = Integer.parseInt(binding.tselBeta.getText().toString());

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

                    }

                    @Override
                    public void onSwipeDown() {
//                        currentCount--;
//                        binding.textBetaProgress
//                                .setText(Integer.toString(currentCount));

                        currentCount--;
                        if (currentCount < 0) {
                            currentCount = 0;
                        }

                        if (binding.tselBeta
                                .getText()
                                .toString()
                                .length() == 0) {
                            binding.textBetaProgress
                                    .setText(MessageFormat.format("{0}",
                                            currentCount));
                        } else if (currentCount <= Integer
                                .parseInt(binding.tselBeta
                                        .getText()
                                        .toString())) {
                            binding.textBetaProgress
                                    .setText(MessageFormat
                                            .format("{0}",
                                                    currentCount));

                        }

                        ObjectAnimator animatorMinus = ObjectAnimator
                                .ofInt(binding.counterBetaProgress,
                                        "progress",
                                        currentCount, currentCount);

                        animatorMinus.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                        animatorMinus.setDuration(GAUGE_ANIMATION_DURATION);
                        animatorMinus.start();
                    }

                    @Override
                    public void onLongClick() {
                        if (currentCount != 0) onMaterialAlert();
                    }

        });

        binding.counterBetaSettings.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new SettingsBetaCounterFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
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
            handler.postDelayed(runnable, 10);
        }
    };

    public void onMaterialAlert() {
        new MaterialAlertDialogBuilder(requireContext(),
                R.style.AlertDialogTheme)
                .setTitle("Reset")
                .setMessage("Вы уверены, что хотите обновить счетчик?")
                .setPositiveButton("Да", (dialogInterface, i) -> {
                    currentCount = 0;
                    binding.textBetaProgress
                            .setText(new StringBuilder()
                                    .append("0"));

                    ObjectAnimator animatorMaterial = ObjectAnimator
                            .ofInt(binding.counterBetaProgress,
                                    "progress", currentCount);
                    animatorMaterial
                            .setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                    animatorMaterial
                            .setDuration(GAUGE_ANIMATION_DURATION);
                    animatorMaterial.start();
                })
                .setNeutralButton("Отмена",
                        (dialogInterface, i) ->
                                dialogInterface.cancel())
                .show();
    }

}
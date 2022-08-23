package com.example.tabiin.ui.zickr.counter.counter_database;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;

import com.example.tabiin.R;
import com.example.tabiin.databinding.FragmentCreateCounterItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;


public class CreateCounterItemFragment extends Fragment {
    FragmentCreateCounterItemBinding binding;
    private Handler handler;
    private String defoltValue = "10";
    private int maxvalue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreateCounterItemBinding
                .inflate(inflater, container, false);

        handler = new Handler();

        binding.titleFromCreateItemDataBaseCounterElement.setCursorVisible(true);
        binding.titleFromCreateItemDataBaseCounterElement.setFocusableInTouchMode(true);
        binding.titleFromCreateItemDataBaseCounterElement.setEnabled(true);

        binding.titleFromCreateItemDataBaseCounterElement.setCursorVisible(true);
        binding.titleFromCreateItemDataBaseCounterElement.setFocusableInTouchMode(true);
        binding.titleFromCreateItemDataBaseCounterElement.setEnabled(true);

        binding.titleDescriptFromCreateItem.setCursorVisible(true);
        binding.titleDescriptFromCreateItem.setFocusableInTouchMode(true);
        binding.titleDescriptFromCreateItem.setEnabled(true);

        binding.saveFromCreateItemDataBaseCounterElement.setOnClickListener(view -> {
            // saveText()
            binding.titleFromCreateItemDataBaseCounterElement.setText(binding
                    .titleFromCreateItemDataBaseCounterElement
                    .getText()
                    .toString()
                    .replaceAll("[\\.\\-,\\s]+", ""));

            binding.titleFromCreateItemDataBaseCounterElement.setCursorVisible(false);
            binding.titleFromCreateItemDataBaseCounterElement.setFocusableInTouchMode(false);
            binding.titleFromCreateItemDataBaseCounterElement.setEnabled(false);

            binding.titleFromCreateItemDataBaseCounterElement.setCursorVisible(false);
            binding.titleFromCreateItemDataBaseCounterElement.setFocusableInTouchMode(false);
            binding.titleFromCreateItemDataBaseCounterElement.setEnabled(false);

            binding.titleDescriptFromCreateItem.setCursorVisible(false);
            binding.titleDescriptFromCreateItem.setFocusableInTouchMode(false);
            binding.titleDescriptFromCreateItem.setEnabled(false);

            if (binding.tselFromCreateItemDataBaseCounterElement
                    .getText().toString().length() == 0) {
                binding.tselFromCreateItemDataBaseCounterElement.setText(defoltValue);
                maxvalue = Integer.parseInt(binding
                        .titleFromCreateItemDataBaseCounterElement
                        .getText()
                        .toString());

                Snackbar.make(requireView(),
                                new StringBuilder()
                                        .append("Вы не ввели цель. По умолчанию: ")
                                        .append(defoltValue),
                                Snackbar.LENGTH_LONG)
                        .show();

            } else {

                if (Integer.parseInt(binding
                        .titleFromCreateItemDataBaseCounterElement
                        .getText().toString()) <= 0) {
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

                    maxvalue = Integer.parseInt(binding
                            .titleFromCreateItemDataBaseCounterElement
                            .getText().toString());

                }
            }

            if (binding.titleFromCreateItemDataBaseCounterElement
                    .getText().toString().length() == 0) {
                binding.titleFromCreateItemDataBaseCounterElement
                        .setText(getRandomString(15));
            }

        });

        binding.editFromCreateItemDataBaseCounterElement
                .setOnClickListener(view -> {

            binding.titleFromCreateItemDataBaseCounterElement.setCursorVisible(true);
            binding.titleFromCreateItemDataBaseCounterElement.setFocusableInTouchMode(true);
            binding.titleFromCreateItemDataBaseCounterElement.setEnabled(true);

            binding.titleFromCreateItemDataBaseCounterElement.setCursorVisible(true);
            binding.titleFromCreateItemDataBaseCounterElement.setFocusableInTouchMode(true);
            binding.titleFromCreateItemDataBaseCounterElement.setEnabled(true);

            binding.titleDescriptFromCreateItem.setCursorVisible(true);
            binding.titleDescriptFromCreateItem.setFocusableInTouchMode(true);
            binding.titleDescriptFromCreateItem.setEnabled(true);

            binding.titleFromCreateItemDataBaseCounterElement.requestFocus();

            binding.titleFromCreateItemDataBaseCounterElement.setSelection(
                    binding.titleFromCreateItemDataBaseCounterElement.getText().length()
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
                imm.showSoftInput(binding.titleFromCreateItemDataBaseCounterElement,
                        InputMethodManager.SHOW_FORCED);
            }

        });

        binding.deleteFromCreateItemDataBaseCounterElement.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new CounterSavesFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        return binding.getRoot();
    }

    public static String getRandomString(int length){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int number = random.nextInt(3);
            long result = 0;
            switch(number){
                case 0:
                    result = Math.round(Math.random()*25+65);
                    sb.append((char) result);
                    break;
                case 1:
                    result = Math.round(Math.random()*25+97);
                    sb.append((char) result);
                    break;
                case 2:
                    sb.append(new Random().nextInt(10));
                    break;
            }


        }
        return sb.toString();
    }
}
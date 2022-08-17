package com.example.tabiin.ui.zickr.counter.counter_database;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.adapters.CounterAdapter;
import com.example.tabiin.database.Employee;
import com.example.tabiin.database.Items;
import com.example.tabiin.databinding.FragmentCounterSavesBinding;
import com.example.tabiin.ui.zickr.counter.counter_settings.general_screen.CounterSettingsFragment;
import com.example.tabiin.viewmodels.CounterViewModel;
import com.google.android.material.floatingactionbutton.*;

import java.util.List;


public class CounterSavesFragment extends Fragment implements CounterAdapter.HandleItemClick {
    private FragmentCounterSavesBinding binding;
    private CounterViewModel viewModel;
    private CounterAdapter counterAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCounterSavesBinding
                .inflate(inflater, container, false);

        binding.fabAddCounter.setOnClickListener(view -> {
            changeFragment(requireActivity(),
                    new CreateCounterItemFragment(),
                    R.id.kontainerFragment,
                    savedInstanceState
            );
        });

        initViewModel();

        return binding.getRoot();

    }

    private void initViewModel() {
        //viewModel = new ViewModelProvider(this).get(CounterViewModel.class);
        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(CounterViewModel.class);
        viewModel.getItemListObsever().observe(getViewLifecycleOwner(), employees -> {
            if (employees == null) {
                binding.noRes.setVisibility(View.VISIBLE);
                binding.recycleCounter.setVisibility(View.GONE);
            } else {
                counterAdapter.setItemsList(employees);
                binding.recycleCounter.setVisibility(View.VISIBLE);
                binding.noRes.setVisibility(View.GONE);
            }
        });
    }

    private void initRecycleView() {
        binding.recycleCounter.setLayoutManager(new LinearLayoutManager(getContext()));
        counterAdapter = new CounterAdapter(getContext(), (CounterAdapter.HandleItemClick) getContext());
        binding.recycleCounter.setAdapter(counterAdapter);
    }


    @Override
    public void itemClick(Items items) {
        viewModel.deleteItem(items);
    }

    @Override
    public void removeItem(Items items) {

    }
}
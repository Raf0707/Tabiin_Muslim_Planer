package com.example.tabiin.ui.kitab.quran;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.R;
import com.example.tabiin.adapters.names.DrawerNamesAdapter;
import com.example.tabiin.adapters.quran.QuranAdapter;
import com.example.tabiin.databinding.FragmentQuranBinding;
import com.example.tabiin.objects.quran.QuranItemContent;
import com.example.tabiin.objects.sures.Sura;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuranFragment extends Fragment {

    private FragmentQuranBinding binding;
    private DrawerNamesAdapter drawerNamesAdapter;

    private ArrayList<QuranItemContent> suresName = new ArrayList<QuranItemContent>();
    private String[] sures = new String[115];

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuranFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KoranFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuranFragment newInstance(String param1, String param2) {
        QuranFragment fragment = new QuranFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Gson gson = new GsonBuilder().create();
        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open("Quran and Tafsir (.json)/1.json");
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();
            Sura sura = gson.fromJson(jsonString, Sura.class);
            Log.d("SURA", sura.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuranBinding.inflate(inflater, container, false);




        return binding.getRoot();
    }
}
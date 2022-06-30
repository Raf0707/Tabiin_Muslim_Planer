package com.example.tabiin.ui.fard.namaz;

import android.os.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;

import android.util.*;
import android.view.*;
import android.widget.*;

import com.example.tabiin.R;
import com.example.tabiin.util.*;

import org.w3c.dom.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;


public class TimeNamazFragment extends Fragment {
    private final String url = "https://www.mihrab.ru";
    public TextView nextNamaz;
    public TextView localtime_next_namaz;
    private TextView hijra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_time_namaz, container, false);

        nextNamaz = view.findViewById(R.id.next_namaz);
        localtime_next_namaz = view.findViewById(R.id.localtime_next_namaz);


        return view;

    }




}





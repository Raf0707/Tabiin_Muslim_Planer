package com.example.tabiin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.example.tabiin.ui.*;

public class MainActivity extends AppCompatActivity implements SimpleAdapter.ViewBinder {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    public boolean setViewValue(View view, Object o, String s) {
        return false;
    }
    
}
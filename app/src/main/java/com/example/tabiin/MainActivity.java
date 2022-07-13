package com.example.tabiin;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;

import com.example.tabiin.databinding.*;
import com.example.tabiin.ui.*;
import com.example.tabiin.ui.zickr.*;
import com.google.android.material.bottomnavigation.*;
import com.google.android.material.navigation.*;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private BottomNavigationView navigation;
    public static int SelectFragment = 0;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.navView);
        navigation.setSelectedItemId(R.id.zickr_general);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.kitab_general:
                //viewFragment(new HomeFragment(), FRAGMENT_HOME);
                break;
            case R.id.fard_general:
                //viewFragment(new OneFragment(), FRAGMENT_OTHER);
                break;
            case R.id.zickr_general:
                changeFragment(this, new GeneralZickrFragment(), R.id.kontainerFragment, null);
                //viewFragment(new TwoFragment(), FRAGMENT_OTHER);
                break;

            case R.id.news_general:
                //viewFragment(new TwoFragment(), FRAGMENT_OTHER);
                break;
        }
        return true;
    }
}
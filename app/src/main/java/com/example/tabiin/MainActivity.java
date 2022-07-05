package com.example.tabiin;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.*;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.example.tabiin.util.*;
import com.google.android.material.bottomnavigation.*;
import com.google.android.material.navigation.*;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private View mainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = findViewById(R.id.mainView);



        mainView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeRight() {

                // todo function to change fragments something like
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.left_to_right,  // enter
                                R.anim.right_to_left // exit
                        );
                        // Переход между фрагментами
                        // При свайпах задействовать анимации читалки (см res/anim/left_to_right и res/anim/right_to_left)
                        //.replace(R.id.fragmentContainer,
                                //selectedFragment).commit();

            }
            public void onSwipeLeft() {
                // todo function to change fragments something like
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.left_to_right,  // enter
                                R.anim.right_to_left // exit
                        );
                // Переход между фрагментами
                // При свайпах задействовать анимации читалки (см res/anim/left_to_right и res/anim/right_to_left)
                //.replace(R.id.fragmentContainer,
                //selectedFragment).commit();
            }


        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
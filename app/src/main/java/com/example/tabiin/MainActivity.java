package com.example.tabiin;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.*;
import android.os.Bundle;
import android.view.*;

import com.example.tabiin.adapters.ViewPagerAdapter;
import com.example.tabiin.databinding.*;
import com.example.tabiin.ui.*;
import com.example.tabiin.ui.about_app.AppAboutFragment;
import com.example.tabiin.ui.fard.*;
import com.example.tabiin.ui.kitab.*;
import com.example.tabiin.ui.useful.*;
import com.example.tabiin.ui.zickr.*;
import com.google.android.material.bottomnavigation.*;
import com.google.android.material.navigation.*;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private GeneralFardFragment generalFardFragment;
    private GeneralZickrFragment generalZickrFragment;
    private GeneralKitabihilFragment generalKitabihilFragment;
    private GeneralUsefulFragment generalUsefulFragment;
    private AppAboutFragment appAboutFragment;

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.fard_general:
                    changeFragment(this, new GeneralFardFragment(), R.id.kontainerFragment, null);
                    binding.mainViewpager.setCurrentItem(0);
                    //viewFragment(new OneFragment(), FRAGMENT_OTHER);
                    break;
                case R.id.zickr_general:
                    changeFragment(this, new GeneralZickrFragment(), R.id.kontainerFragment, null);
                    binding.mainViewpager.setCurrentItem(1);
                    //viewFragment(new TwoFragment(), FRAGMENT_OTHER);
                    break;

                case R.id.kitab_general:
                    changeFragment(this, new GeneralKitabihilFragment(), R.id.kontainerFragment, null);
                    binding.mainViewpager.setCurrentItem(2);
                    break;

                case R.id.news_general:
                    changeFragment(this, new GeneralUsefulFragment(), R.id.kontainerFragment, null);
                    binding.mainViewpager.setCurrentItem(3);
                    //viewFragment(new TwoFragment(), FRAGMENT_OTHER);
                    break;

                case R.id.about_app:
                    changeFragment(this, new AppAboutFragment(), R.id.kontainerFragment, null);
                    binding.mainViewpager.setCurrentItem(4);
                    break;
            }
            return true;


        });

//        binding.navView.setOnNavigationItemSelectedListener(
//                item -> {
//                    switch (item.getItemId()) {
//                        case R.id.fard_general:
//                            changeFragment(this, new GeneralFardFragment(), R.id.kontainerFragment, null);
//                            binding.mainViewpager.setCurrentItem(1);
//                            //viewFragment(new OneFragment(), FRAGMENT_OTHER);
//                            break;
//                        case R.id.zickr_general:
//                            changeFragment(this, new GeneralZickrFragment(), R.id.kontainerFragment, null);
//                            binding.mainViewpager.setCurrentItem(2);
//                            //viewFragment(new TwoFragment(), FRAGMENT_OTHER);
//                            break;
//
//                        case R.id.kitab_general:
//                            changeFragment(this, new GeneralKitabihilFragment(), R.id.kontainerFragment, null);
//                            binding.mainViewpager.setCurrentItem(3);
//                            break;
//
//                        case R.id.news_general:
//                            changeFragment(this, new GeneralUsefulFragment(), R.id.kontainerFragment, null);
//                            binding.mainViewpager.setCurrentItem(4);
//                            //viewFragment(new TwoFragment(), FRAGMENT_OTHER);
//                            break;
//
//                        case R.id.about_app:
//                            changeFragment(this, new AppAboutFragment(), R.id.kontainerFragment, null);
//                            binding.mainViewpager.setCurrentItem(5);
//                            break;
//                    }
//                    return false;
//                });

        binding.mainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    binding.navView.getMenu().getItem(0).setChecked(false);
                }

                binding.navView.getMenu().getItem(position).setChecked(true);
                menuItem = binding.navView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

        setupViewPager(binding.mainViewpager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        generalFardFragment = new GeneralFardFragment();
        generalZickrFragment = new GeneralZickrFragment();
        generalKitabihilFragment = new GeneralKitabihilFragment();
        generalUsefulFragment = new GeneralUsefulFragment();
        appAboutFragment = new AppAboutFragment();

        adapter.addFragment(generalFardFragment);
        adapter.addFragment(generalZickrFragment);
        adapter.addFragment(generalKitabihilFragment);
        adapter.addFragment(generalUsefulFragment);
        adapter.addFragment(appAboutFragment);
        viewPager.setAdapter(adapter);
    }

}




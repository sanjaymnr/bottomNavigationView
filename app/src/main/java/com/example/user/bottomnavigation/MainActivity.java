package com.example.user.bottomnavigation;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_search:
                        loadFragment(new FirstFragment());
                        break;

                    case R.id.menu_saved_lists:
                        loadFragment(new SecondFragment());
                        break;

                    case R.id.menu_applications:
                        loadFragment(new ThirdFragment());
                        break;

                    case R.id.menu_job_alerts:
                        loadFragment(new FourthFragment());
                        break;
                    case R.id.menu_profile:
                        loadFragment(new FifthFragment());
                        break;
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.menu_search);
    }

    private void loadFragment(android.app.Fragment fragment) {
        // create a FragmentManager
        android.app.FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        android.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.rl_container, fragment);
        fragmentTransaction.commit(); // save the changes
    }


}
package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Projects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        /*check which bottom on tab bar was pressed */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_projects);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_projects) {
                return true;
            } else if (item.getItemId() == R.id.bottom_Home) {
                startActivity(new Intent(getApplicationContext(), WelcomePage.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_setting) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }  else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_trombi) {
                startActivity(new Intent(getApplicationContext(), Trombinoscope.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else {
                return false;
            }
        });

    }
}
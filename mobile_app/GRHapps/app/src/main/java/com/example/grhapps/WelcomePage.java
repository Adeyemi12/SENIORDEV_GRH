package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.ImageView;

import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class WelcomePage extends AppCompatActivity {

    private TextView welcomeUsername;
    private ImageView photoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        /*check which bottom on tab bar was pressed */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_Home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_projects) {
                startActivity(new Intent(getApplicationContext(), Projects.class));
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
        /* check which bottom on tab bar was pressed (end) */

        welcomeUsername = findViewById(R.id.welcome_username);
        photoFrame = findViewById(R.id.photo_frame);
        ApiRequestManager.initRequestQueue(Volley.newRequestQueue(getApplicationContext()));




        /*Set user name*/
        welcomeUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant la modification du texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant la modification du texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Mettre à jour la largeur du TextView en fonction du nombre de caractères
                int charCount = s.length();
                int minWidth = 214; // Largeur minimale en pixels
                int maxWidth = 800; // Largeur maximale en pixels
                int widthPerChar = 20; // Largeur en pixels par caractère

                int width = minWidth + (charCount * widthPerChar); // Calcul de la largeur en fonction du nombre de caractères
                if (width > maxWidth) {
                    width = maxWidth; // Limiter la largeur maximale
                }

                welcomeUsername.getLayoutParams().width = width;
                welcomeUsername.requestLayout();
            }
        });
        welcomeUsername.setText(GlobalVariables.UserNameApp);
        photoFrame.setImageResource(R.drawable.new_client);
    }
}
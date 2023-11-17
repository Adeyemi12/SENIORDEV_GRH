package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.ImageView;


public class WelcomePage extends AppCompatActivity {

    private TextView welcomeUsername;
    private ImageView photoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        welcomeUsername = findViewById(R.id.welcome_username);
        photoFrame = findViewById(R.id.photo_frame);

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

        photoFrame.setImageResource(R.drawable.new_client);
        mApi();
    }

    public void mApi() {
        Intent intent = new Intent(this, ApiManagement.class);
        startActivity(intent);
    }
}
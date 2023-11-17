package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public ImageButton button;
    public TextView textViewClickable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* for the sign up button */
        button =  findViewById(R.id.button_signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                open_Signup();
            }
        });

        /* for the sign in button */
        textViewClickable = (TextView) findViewById(R.id.button_signin);
        textViewClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_Signin();
            }
        });

        }
    public void open_Signup() {
         Intent intent = new Intent(this, Sign_up.class );
         startActivity(intent);
    }
    public void open_Signin() {
        Intent intent = new Intent(this, Sign_in.class);
        startActivity(intent);
    }
}
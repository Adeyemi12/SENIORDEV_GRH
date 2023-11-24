package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    public Button button;
    public TextView textViewClickable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setSelectedItemId(R.id.bottom_Home);
//
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.bottom_Home:
//                    return true;
//                case R.id.bottom_projects:
//                    startActivity(new Intent(getApplicationContext(), Projects.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//
//            }
//        });


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
//         Intent intent = new Intent(this, Sign_up.class );
        Intent intent = new Intent(this, WelcomePage.class );
         startActivity(intent);
    }
    public void open_Signin() {
        Intent intent = new Intent(this, Sign_in.class);
        startActivity(intent);
    }
}
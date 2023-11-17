package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    public EditText username;
    public EditText password;
    public Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText)  findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginbutton = (Button) findViewById(R.id.button_login);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals(("dev123"))) {
                    Welcome_page();

                } else {
                    Toast.makeText(Sign_up.this, "Login failed!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void Welcome_page() {
        Intent intent = new Intent(this, WelcomePage.class);
        startActivity(intent);
    }
}
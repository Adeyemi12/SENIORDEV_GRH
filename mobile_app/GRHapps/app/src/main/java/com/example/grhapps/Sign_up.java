package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import org.mindrot.jbcrypt.BCrypt;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class Sign_up extends AppCompatActivity {
    public EditText username_input;
    public EditText password_input;
    public Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username_input = findViewById(R.id.username);
        password_input = findViewById(R.id.password);
        loginbutton = findViewById(R.id.button_login);
        ApiRequestManager.initRequestQueue(Volley.newRequestQueue(getApplicationContext()));


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((username_input.getText().toString().equals("kevin") || username_input.getText().toString().equals("naruto")) //check email and name
                        && password_input.getText().toString().equals("12345")) {
                    /*Here set value I need for the this app */
                    GlobalVariables.UserNameApp = username_input.getText().toString();
                    /* End */
                    Welcome_page();
                } else {
                    Toast.makeText(Sign_up.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }

//                ApiRequestManager.makeGetRequest("https://438d-137-255-24-183.ngrok-free.app/api/userss", new ApiRequestManager.ApiResponseListener() {
//                    @Override
//                    public void onSuccess(String response) {
//                        // Handle successful response
//                        Log.d("API Response", response);
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//
//                            JSONArray users_array = jsonObject.getJSONArray("hydra:member");
//                            boolean find = false;
//                            for (int a = 0; a < users_array.length(); a++) {
//                                JSONObject Big_array = users_array.getJSONObject(a);
//
//                                String email_u = Big_array.getString("email");
//                                String username_u = Big_array.getString("prenom");
//                                String password_u = Big_array.getString("password");
//                                String pass_input = password_input.getText().toString();
//                                if ((username_input.getText().toString().equals(username_u) || username_input.getText().toString().equals(email_u)) //check email and name
//                                        && pass_input.equals("qwerty")) {
//                                    /*Here set value I need for the this app */
//                                    GlobalVariables.UserNameApp = username_u;
//                                    GlobalVariables.UserEmailApp = email_u;
//                                    GlobalVariables.UserSurnameApp =  Big_array.getString("nom");
//                                    /* End */
//                                    Welcome_page();
//                                    find = true;
//                                    break;
//                                }
//                            }
//                            if (!find) {
////                              si le nom ne corresponds a aucun user dans la base de donnee send le message ci-dessous.
//                                Toast.makeText(Sign_up.this, "Login failed!", Toast.LENGTH_SHORT).show();
//                            }
//                            // Process JSON data as needed
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(String error) {
//                        // Handle error
//                        Log.e("API Error level_authen", error);
//                    }
//                });


            }
        });
    }

    public void Welcome_page() {
        Intent intent = new Intent(this, WelcomePage.class);
        startActivity(intent);
    }
}
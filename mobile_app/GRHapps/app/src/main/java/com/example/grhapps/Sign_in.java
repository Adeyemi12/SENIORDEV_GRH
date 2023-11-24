package com.example.grhapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Sign_in extends AppCompatActivity {

    public Button button_submit;
    public EditText Picture_input;
    public EditText Name_input;
    public EditText Surname_input;
    public EditText password_input;
    public EditText Address_input;
    public EditText PhoneNumber_input;
    public EditText Email_input;
    public EditText Poste_input;
    public EditText Department_input;
    public EditText salary_input;
    public EditText contract_input;
    public EditText Status_input;
    public EditText skill_input;
    public DatePicker hired_date;
    public EditText hired_time;
    public DatePicker log_at_date;
    public EditText log_at_time;
    public DatePicker log_out_date;
    public EditText log_out_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        button_submit = findViewById(R.id.button_submit);
        Picture_input = findViewById(R.id.tvPhoto);
        Email_input = findViewById(R.id.tvEmail);
        Name_input = findViewById(R.id.tvName);
        Surname_input = findViewById(R.id.tvSurname);
        password_input = findViewById(R.id.tvPassword);
        Address_input = findViewById(R.id.tvAddress);
        PhoneNumber_input = findViewById(R.id.tvPhoneNumber);
        Poste_input = findViewById(R.id.tvPosition);
        Department_input = findViewById(R.id.tvDepartment);
        salary_input = findViewById(R.id.tvSalary);
        contract_input = findViewById(R.id.tvSalary);
        Status_input = findViewById(R.id.tvStatut);
        skill_input = findViewById(R.id.tvSkill);
        hired_date = findViewById(R.id.datePicker_hired);
        hired_time = findViewById(R.id.tvhired_time);
        log_at_date = findViewById(R.id.datePicker_log_at);
        log_at_time = findViewById(R.id.tvlogat_time);
        log_out_date = findViewById(R.id.datePicker_logout);
        log_out_time = findViewById(R.id.tvlogout_time);


        ApiRequestManager.initRequestQueue(Volley.newRequestQueue(getApplicationContext()));
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Picture", Picture_input.getText().toString());
                Log.d("Name", Name_input.getText().toString());
                Log.d("Surname", Surname_input.getText().toString());
                Log.d("Password", password_input.getText().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
                String currentDate = sdf.format(new Date());
                /* Make a post */
                JSONObject requestBody = new JSONObject();

                try {
                    requestBody.put("photo", Picture_input.getText().toString());
                    requestBody.put("nom", Surname_input.getText().toString());
                    requestBody.put("prenom", Name_input.getText().toString());
                    requestBody.put("password", password_input.getText().toString());
                    requestBody.put("email", Email_input.getText().toString());
                    requestBody.put("adresse", Address_input.getText().toString());
                    requestBody.put("numero", PhoneNumber_input.getText().toString());
                    requestBody.put("departement", Department_input.getText().toString());
                    requestBody.put("competences", skill_input.getText().toString());
                    requestBody.put("salaire", 2000);
                    requestBody.put("profil", Status_input.getText().toString());
                    requestBody.put("posteOccupe", Poste_input.getText().toString());
                    requestBody.put("dureeDuContrat", 12);
                    requestBody.put("hiredAt", currentDate);
                    requestBody.put("logAt", currentDate);
                    requestBody.put("logoutAt", currentDate);

                    String json = requestBody.toString();
                    Log.d("Generated JSON", json);

                    // Add other parameters as needed
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                ApiRequestManager.makePostRequest("https://438d-137-255-24-183.ngrok-free.app/api/users", requestBody, new ApiRequestManager.ApiResponseListener() {
                    @Override
                    public void onSuccess(String response) {
                        // Handle successful response
                        Log.d("API Response", response);
                        Log.d("Push", "Success");
                        open_Signup();
                    }

                    @Override
                    public void onError(String error) {
                        // Handle error
                        Log.e("API Error", error);
                    }
                });

            }
        });
    }
    public void open_Signup() {
        Intent intent = new Intent(this, Sign_up.class );
        startActivity(intent);
    }
}
package com.example.grhapps;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

public class ApiManagement extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://be42-137-255-20-177.ngrok-free.app/api/userss/1";
    private TextView welcomeUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        welcomeUsername = findViewById(R.id.welcome_username);

        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        // String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Log the response
                Log.d("Response", response);

                // Parse the response and retrieve the name
                try {
                    JSONObject jsonObject = new JSONObject(response);

//                    String jsonString = jsonObject.toString();
//                    Toast.makeText(getApplicationContext(), "Response :" + jsonString, Toast.LENGTH_LONG).show(); // Display the response on screen
                    String name = jsonObject.getString("prenom");
                    JSONArray firstarrayjson = jsonObject.getJSONArray("abilities");
//
//                    for (int a = 0; a < firstarrayjson.length(); a++) {
//                        JSONObject abilityObject = firstarrayjson.getJSONObject(a);
//
//                        // Get the nested "ability" object
//                        JSONObject nestedAbilityObject = abilityObject.getJSONObject("ability");
//
//                        // Get the name and URL from the nested "ability" object
//                        String abilityName = nestedAbilityObject.getString("name");
//                        String abilityUrl = nestedAbilityObject.getString("url");
//
//                        // Do something with the extracted information (e.g., display in a toast)
//                        Toast.makeText(getApplicationContext(), "Ability Name: " + abilityName + "\nAbility URL: " + abilityUrl, Toast.LENGTH_LONG).show();
//                        Log.i("Ability Info", "Ability Name: " + abilityName + ", Ability URL: " + abilityUrl);
//                    }

                    welcomeUsername.setText(name);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error", error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

}

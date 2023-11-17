package com.example.grhapps;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

public class ApiRequestManager {

    private static RequestQueue requestQueue;

    // Initialize the RequestQueue in the constructor or use a method like initRequestQueue

    public static void initRequestQueue(RequestQueue queue) {
        requestQueue = queue;
    }

    public static void makeGetRequest(String url, final ApiResponseListener responseListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseListener.onError(error.toString());
                    }
                });

        requestQueue.add(stringRequest);
    }

    public static void makePostRequest(String url, final JSONObject requestBody, final ApiResponseListener responseListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseListener.onError(error.toString());
                    }
                }) {
            @Override
            public byte[] getBody() {
                return requestBody.toString().getBytes();
            }
        };

        requestQueue.add(stringRequest);
    }

    // Interface to handle API responses
    public interface ApiResponseListener {
        void onSuccess(String response);
        void onError(String error);
    }
}

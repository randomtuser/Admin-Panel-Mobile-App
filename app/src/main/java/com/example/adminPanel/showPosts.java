package com.example.adminPanel;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.university.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;



public class showPosts extends AppCompatActivity {

    private RequestQueue requestQueue;
    private TextView posts;
    private String url = "https://new---app.azurewebsites.net/users";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_posts);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        posts = (TextView) findViewById(R.id.textView3);

    }

    public  void prikaziPosts(View view){
        if (view != null){
            JsonArrayRequest request = new JsonArrayRequest(url, jsonArrayListener, errorListener);
            requestQueue.add(request);
        }
    }

    private Response.Listener<JSONArray> jsonArrayListener = new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response){
            ArrayList<String> data = new ArrayList<>();

            for (int i = 0; i < response.length(); i++){
                try {
                    JSONObject object =response.getJSONObject(i);
                    String id = object.getString("id");
                    String name = object.getString("firstName");
                    String surname = object.getString("lastName");
                    String birthDate = object.getString("birthDate");
                    String email = object.getString("email");

                    data.add("id: " + id +"\nname : "+name + "\nsurname :" + surname + "\nemail : " + email +" " + "\nbirthDate : "+ birthDate +"\n");

                } catch (JSONException e){
                    e.printStackTrace();
                    return;

                }
            }

            posts.setText("");


            for (String row: data){
                String currentText = posts.getText().toString();
                posts.setText(currentText + "\n\n" + row);
            }

        }

    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("REST error", error.getMessage());
        }
    };


}

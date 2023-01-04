package com.example.adminPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.university.R;

public class options extends AppCompatActivity {

    private Button delete;
    private Button showAll;
    private Button showPosts;
    private Button addshowPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        showAll = (Button) findViewById(R.id.vsi);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAll();
            }});{}

        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove();
            }});{}

        showPosts = (Button) findViewById(R.id.showPosts);
        showPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPosts();
            }});{}

        addshowPosts = (Button) findViewById(R.id.addshowPosts);
        addshowPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addshowPosts();
            }});{}



    }
    public  void showAll(){
        Intent intent = new Intent(this, com.example.adminPanel.showAll.class);
        startActivity(intent);
    }
    public  void remove(){
        Intent intent2 = new Intent(this, delete.class);
        startActivity(intent2);
    }

    public  void showPosts(){
        Intent intent2 = new Intent(this, showPosts.class);
        startActivity(intent2);
    }
    public  void addshowPosts(){
        Intent intent2 = new Intent(this, addPosts.class);
        startActivity(intent2);
    }
}
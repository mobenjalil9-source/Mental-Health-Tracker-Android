package com.example.mentalhealthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button addMood, viewMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMood = findViewById(R.id.btnAddMood);
        viewMood = findViewById(R.id.btnViewMood);

        addMood.setOnClickListener(v ->
                startActivity(new Intent(this, AddMoodActivity.class)));

        viewMood.setOnClickListener(v ->
                startActivity(new Intent(this, ViewMoodActivity.class)));
    }
}

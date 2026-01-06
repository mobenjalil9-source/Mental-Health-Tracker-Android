package com.example.mentalhealthapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMoodActivity extends AppCompatActivity {

    Spinner moodSpinner;
    SeekBar stressBar;
    Button saveBtn;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);

        moodSpinner = findViewById(R.id.spinnerMood);
        stressBar = findViewById(R.id.seekStress);
        saveBtn = findViewById(R.id.btnSave);
        dbHelper = new DBHelper(this);

        String[] moods = {"Happy", "Sad", "Neutral", "Angry", "Anxious"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                moods
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        moodSpinner.setAdapter(adapter);

        saveBtn.setOnClickListener(v -> saveData());
    }

    private void saveData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        values.put("mood", moodSpinner.getSelectedItem().toString());
        values.put("stress", stressBar.getProgress());

        db.insert("mood_table", null, values);
        Toast.makeText(this, "Mood Saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}

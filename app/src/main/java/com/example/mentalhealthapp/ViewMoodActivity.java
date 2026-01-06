package com.example.mentalhealthapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewMoodActivity extends AppCompatActivity {

    TextView txtData;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mood);

        txtData = findViewById(R.id.txtMoodData);
        dbHelper = new DBHelper(this);

        showData();
    }

    private void showData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM mood_table", null);

        StringBuilder data = new StringBuilder();
        while (cursor.moveToNext()) {
            data.append("Date: ").append(cursor.getString(1))
                    .append("\nMood: ").append(cursor.getString(2))
                    .append("\nStress: ").append(cursor.getInt(3))
                    .append("\n\n");
        }
        txtData.setText(data.toString());
        cursor.close();
    }
}

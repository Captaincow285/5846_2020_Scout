package com.example.a5846_2020_scout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MatchActivityTele extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceStat)
    {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_match_teleop);
        Log.d("Working","MatchActivityTele works!");

        Button submitButton = findViewById(R.id.teleopSubmitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

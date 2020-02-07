package com.example.a5846_2020_scout.match;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;

public class MatchActivityAuto extends AppCompatActivity
{
    protected void onCreate(Bundle saveInstanceStat)
    {
        super.onCreate(saveInstanceStat);
        setContentView(R.layout.activity_match_auto);

        Button autoSubmitButton = findViewById(R.id.autoSubmitButton);

        autoSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

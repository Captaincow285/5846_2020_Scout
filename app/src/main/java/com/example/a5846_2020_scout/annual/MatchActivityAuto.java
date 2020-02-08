package com.example.a5846_2020_scout.annual;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import roomDatabase.Match;

public class MatchActivityAuto extends AppCompatActivity
{
    private int highIn = 0;
    private int highOut = 0;
    private int low = 0;

    protected void onCreate(Bundle saveInstanceStat)
    {
        super.onCreate(saveInstanceStat);
        setContentView(R.layout.activity_match_auto);
        final boolean practiceMode = (boolean) getIntent().getSerializableExtra("Practice Mode");
        Match recording;
        if(practiceMode)
        {
            recording = (Match) getIntent().getSerializableExtra("Database");
        }

        final Button autoSubmitButton = findViewById(R.id.SubmitButton);
        Button highInPlusButton = findViewById(R.id.highInPlusButton);
        Button highInMinusButton = findViewById(R.id.highInMinusButton);
        Button highOutPlusButton = findViewById(R.id.highOutPlusButton);
        Button highOutMinusButton = findViewById(R.id.highOutMinusButton);
        Button lowPlusButton = findViewById(R.id.lowPlusButton);
        Button lowMinusButton = findViewById(R.id.lowMinusButton);
        final Button confirmationButton = findViewById(R.id.confirmationButtonAuto);

        confirmationButton.setVisibility(View.GONE);

        TextView highInNumber = findViewById(R.id.highInNumber);
        TextView highOutNumber = findViewById(R.id.highOutNumber);
        TextView lowNumber = findViewById(R.id.lowNumber);

        highInNumber.setText(highIn);
        highOutNumber.setText(highOut);
        lowNumber.setText(low);

        highInPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highIn++;
            }
        });

        highInMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        highOutPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        highOutMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lowPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lowMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        autoSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmationButton.setVisibility(View.VISIBLE);
                autoSubmitButton.setVisibility(View.GONE);
            }
        });

        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(practiceMode)
                {
                    PracticeMatch practice = new PracticeMatch();
                }
                else
                {

                }
            }
        });
    }
}

package com.example.a5846_2020_scout.annual;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;

public class MatchActivityTele extends AppCompatActivity
{
    private int highIn = 0;
    private int highOut = 0;
    private int low = 0;
    private int cellCount = 0;

    protected void onCreate(Bundle savedInstanceStat)
    {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_match_teleop);
        Log.d("Working","MatchActivityTele works!");

        final boolean practiceMode = (boolean) getIntent().getSerializableExtra("Practice Mode");
        final Intent end = new Intent(getApplicationContext(), MatchActivityEnd.class);

        final Button autoSubmitButton = findViewById(R.id.SubmitButton);
        Button highInPlusButton = findViewById(R.id.highInPlusButton);
        Button highInMinusButton = findViewById(R.id.highInMinusButton);
        Button highOutPlusButton = findViewById(R.id.highOutPlusButton);
        Button highOutMinusButton = findViewById(R.id.highOutMinusButton);
        Button lowPlusButton = findViewById(R.id.lowPlusButton);
        Button lowMinusButton = findViewById(R.id.lowMinusButton);
        Button maxCountPlusButton = findViewById(R.id.maxCountPlusButton);
        Button maxCountMinusButton = findViewById(R.id.maxCountMinusButton);
        final Button confirmationButton = findViewById(R.id.confirmationButtonAuto);
        final Switch controlSpinSwitch = findViewById(R.id.controlSpinSwitch);
        final Switch controlPositionSwitch = findViewById(R.id.controlPositionSwitch);

        confirmationButton.setVisibility(View.GONE);

        final TextView highInNumber = findViewById(R.id.highInNumber);
        final TextView highOutNumber = findViewById(R.id.highOutNumber);
        final TextView lowNumber = findViewById(R.id.lowNumber);
        final TextView maxCountNumber = findViewById(R.id.maxCountNumber);

        highInNumber.setText(highIn);
        highOutNumber.setText(highOut);
        lowNumber.setText(low);
        maxCountNumber.setText(cellCount);

        maxCountPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cellCount++;
            }
        });

        maxCountMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cellCount != 0)
                {
                    cellCount--;
                }
            }
        });

        highInPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highIn++;
                highInNumber.setText(highIn);
            }
        });

        highInMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(highIn != 0)
                {
                    highIn--;
                    highInNumber.setText(highIn);
                }
            }
        });

        highOutPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highOut ++;
                highOutNumber.setText(highOut);
            }
        });

        highOutMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(highOut != 0)
                {
                    highOut--;
                    highOutNumber.setText(highOut);
                }
            }
        });

        lowPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low++;
                lowNumber.setText(low);
            }
        });

        lowMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(low != 0)
                {
                    low--;
                    lowNumber.setText(low);
                }
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
                    PracticeMatch practice = (PracticeMatch) getIntent().getSerializableExtra("Practice Object");
                    practice.setControlPanelEnabled(controlSpinSwitch.isChecked());
                    practice.setControlPanelActivated(controlPositionSwitch.isChecked());
                }
                else
                {

                }
            }
        });
    }
}

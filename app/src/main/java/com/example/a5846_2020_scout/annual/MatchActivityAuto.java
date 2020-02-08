package com.example.a5846_2020_scout.annual;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;

import java.io.Serializable;

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

        final boolean practiceMode = getIntent().getBooleanExtra("Practice Mode", true);
        final Intent teleop = new Intent(getApplicationContext(), MatchActivityTele.class);

        final Switch sectCross = findViewById(R.id.sectCross);
        final Button autoSubmitButton = findViewById(R.id.SubmitButton);
        Button highInPlusButton = findViewById(R.id.highInPlusButton);
        Button highInMinusButton = findViewById(R.id.highInMinusButton);
        Button highOutPlusButton = findViewById(R.id.highOutPlusButton);
        Button highOutMinusButton = findViewById(R.id.highOutMinusButton);
        Button lowPlusButton = findViewById(R.id.lowPlusButton);
        Button lowMinusButton = findViewById(R.id.lowMinusButton);
        final Button confirmationButton = findViewById(R.id.confirmationButtonAuto);

        confirmationButton.setVisibility(View.GONE);

        final TextView highInNumber = findViewById(R.id.highInNumber);
        final TextView highOutNumber = findViewById(R.id.highOutNumber);
        final TextView lowNumber = findViewById(R.id.lowNumber);

        highInNumber.setText(Integer.toString(highIn));
        highOutNumber.setText(Integer.toString(highOut));
        lowNumber.setText(Integer.toString(low));

        highInPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highIn++;
                highInNumber.setText(Integer.toString(highIn));
            }
        });

        highInMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(highIn != 0)
                {
                    highIn--;
                    highInNumber.setText(Integer.toString(highIn));
                }
            }
        });

        highOutPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highOut ++;
                highOutNumber.setText(Integer.toString(highOut));
            }
        });

        highOutMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(highOut != 0)
                {
                    highOut--;
                    highOutNumber.setText(Integer.toString(highOut));
                }
            }
        });

        lowPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low++;
                lowNumber.setText(Integer.toString(low));
            }
        });

        lowMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(low != 0)
                {
                    low--;
                    lowNumber.setText(Integer.toString(low));
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
                    PracticeMatch practice = new PracticeMatch();
                    practice.setCrossedSector(sectCross.isChecked());
                    practice.setAutoHighInnerGoal(highIn);
                    practice.setAutoHighOuterGoal(highOut);
                    practice.setAutoLowGoal(low);
                    teleop.putExtra("Practice Object", (Parcelable) practice);
                    teleop.putExtra("Practice Mode", practiceMode);
                    startActivity(teleop);
                }
                else
                {
                    Match recording = (Match) getIntent().getParcelableExtra("");
                    recording.setCrossedSector(sectCross.isChecked());
                    recording.setAutoHighInnerGoal(highIn);
                    recording.setAutoHighOuterGoal(highOut);
                    recording.setAutoLowGoal(low);
                    teleop.putExtra("Database", (Parcelable) recording);
                    teleop.putExtra("Practice Mode", practiceMode);
                    startActivity(teleop);
                }
            }
        });
    }
}

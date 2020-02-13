package com.example.a5846_2020_scout.annual.gui_func;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.annual.PracticeMatch;

import org.parceler.Parcels;

import com.example.a5846_2020_scout.roomDatabase.Match;

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

        final boolean practiceMode = getIntent().getBooleanExtra("Practice Mode", true);
        final Intent end = new Intent(getApplicationContext(), MatchActivityEnd.class);

        final Button submitButton = findViewById(R.id.SubmitButton);
        Button highInPlusButton = findViewById(R.id.highInPlusButton);
        Button highInMinusButton = findViewById(R.id.highInMinusButton);
        Button highOutPlusButton = findViewById(R.id.highOutPlusButton);
        Button highOutMinusButton = findViewById(R.id.highOutMinusButton);
        Button lowPlusButton = findViewById(R.id.lowPlusButton);
        Button lowMinusButton = findViewById(R.id.lowMinusButton);
        Button maxCountPlusButton = findViewById(R.id.maxCountPlusButton);
        Button maxCountMinusButton = findViewById(R.id.maxCountMinusButton);
        final Switch controlSpinSwitch = findViewById(R.id.controlSpinSwitch);
        final Switch controlPositionSwitch = findViewById(R.id.controlPositionSwitch);

        final TextView highInNumber = findViewById(R.id.highInNumber);
        final TextView highOutNumber = findViewById(R.id.highOutNumber);
        final TextView lowNumber = findViewById(R.id.lowNumber);
        final TextView maxCountNumber = findViewById(R.id.maxCountNumber);

        highInNumber.setText(Integer.toString(highIn));
        highOutNumber.setText(Integer.toString(highOut));
        lowNumber.setText(Integer.toString(low));
        maxCountNumber.setText(Integer.toString(cellCount));

        maxCountPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cellCount++;
                maxCountNumber.setText(Integer.toString(cellCount));
            }
        });

        maxCountMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cellCount != 0)
                {
                    cellCount--;
                    maxCountNumber.setText(Integer.toString(cellCount));
                }
            }
        });

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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(practiceMode)
                {
                    PracticeMatch practice = Parcels.unwrap(getIntent().getParcelableExtra("Practice Object"));
                    practice.setControlPanelEnabled(controlSpinSwitch.isChecked());
                    practice.setControlPanelActivated(controlPositionSwitch.isChecked());
                    practice.setTeleHighInnerGoal(highIn);
                    practice.setTeleHighOuterGoal(highOut);
                    practice.setTeleLowGoal(low);
                    end.putExtra("Practice Object", Parcels.wrap(practice));
                    end.putExtra("Practice Mode", practiceMode);
                    startActivity(end);
                }
                else
                {
                    Match recording = Parcels.unwrap(getIntent().getParcelableExtra("MatchFromAuto"));
                    recording.setControlPanelEnabled(controlSpinSwitch.isChecked());
                    recording.setControlPanelActivated(controlPositionSwitch.isChecked());
                    recording.setMaxCellsCarried(cellCount);
                    recording.setTeleHighInnerGoal(highIn);
                    recording.setTeleHighOuterGoal(highOut);
                    recording.setTeleLowGoal(low);
                    end.putExtra("MatchFromTele", Parcels.wrap(recording));
                    end.putExtra("Practice Mode", practiceMode);
                    startActivity(end);
                }
            }
        });
    }
}

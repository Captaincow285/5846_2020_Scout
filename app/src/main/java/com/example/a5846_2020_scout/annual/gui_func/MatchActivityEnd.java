package com.example.a5846_2020_scout.annual.gui_func;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.annual.PracticeMatch;

import org.parceler.Parcels;

import com.example.a5846_2020_scout.roomDatabase.Match;

public class MatchActivityEnd extends AppCompatActivity
{
    private int position;

    protected void onCreate(Bundle saveInstanceStat)
    {
        super.onCreate(saveInstanceStat);
        setContentView(R.layout.activity_match_end);

        final boolean practiceMode = getIntent().getBooleanExtra("Practice Mode", true);
        final Intent pracReview = new Intent(getApplicationContext(), MatchActivityPracScore.class);
        final Intent review = new Intent(getApplicationContext(), MatchActivityReview.class);

        final Switch climbSwitch = findViewById(R.id.climbSwitch);
        final Switch parkSwitch = findViewById(R.id.parkSwitch);
        final SeekBar robotHangPosition = findViewById(R.id.robotHangPosition);
        Button submitButton = findViewById(R.id.SubmitButton);

        /*
        climbSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(parkSwitch.isChecked())
                {
                    parkSwitch.setChecked(false);
                    climbSwitch.setChecked(true);
                }
            }
        });

        parkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(climbSwitch.isChecked())
                {
                    climbSwitch.setChecked(false);
                    parkSwitch.setChecked(true);
                }
            }
        });
         */

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = robotHangPosition.getProgress();
                if(practiceMode)
                {
                    PracticeMatch practice = Parcels.unwrap(getIntent().getParcelableExtra("Practice Object"));
                    practice.setEndClimb(climbSwitch.isChecked());
                    practice.setEndPark(parkSwitch.isChecked());
                    practice.setHangPosition(position);
                    pracReview.putExtra("Practice Object", Parcels.wrap(practice));
                    startActivity(pracReview);
                }
                else
                {
                    Match recording = Parcels.unwrap(getIntent().getParcelableExtra("MatchFromTele"));
                    recording.setEndClimb(climbSwitch.isChecked());
                    recording.setEndPark(parkSwitch.isChecked());
                    recording.setHangPosition(position);
                    review.putExtra("MatchFromEnd", Parcels.wrap(recording));
                    startActivity(review);
                }
            }
        });
    }
}

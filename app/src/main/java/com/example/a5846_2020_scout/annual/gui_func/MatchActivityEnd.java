package com.example.a5846_2020_scout.annual.gui_func;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

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

        final Toast noGo = Toast.makeText(getApplicationContext(), "Cannot Climb and Park at same time.", Toast.LENGTH_LONG);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = robotHangPosition.getProgress();
                if(practiceMode)
                {
                    PracticeMatch practice = Parcels.unwrap(getIntent().getParcelableExtra("Practice Object"));
                    practice.setEndClimb(climbSwitch.isChecked());
                    practice.setEndPark(parkSwitch.isChecked());
                    if(climbSwitch.isChecked()) {
                        practice.setHangPosition(position);
                    }
                    else
                    {
                        practice.setHangPosition(-1);
                    }
                    pracReview.putExtra("Practice Object", Parcels.wrap(practice));
                    startActivity(pracReview);
                }
                else
                {
                    boolean singleSelect = climbSwitch.isChecked() ^ parkSwitch.isChecked();
                    if(singleSelect) {
                        Match recording = Parcels.unwrap(getIntent().getParcelableExtra("MatchFromTele"));
                        recording.setEndClimb(climbSwitch.isChecked());
                        recording.setEndPark(parkSwitch.isChecked());
                        if(climbSwitch.isChecked()) {
                            recording.setHangPosition(position);
                        }
                        else
                        {
                            recording.setHangPosition(-1);
                        }
                        review.putExtra("MatchFromEnd", Parcels.wrap(recording));
                        startActivity(review);
                    }
                    else
                    {
                        noGo.show();
                    }
                }
            }
        });
    }
}

package com.example.a5846_2020_scout.annual.gui_func;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.annual.PracticeMatch;
import com.example.a5846_2020_scout.common.MainActivity;
import com.example.a5846_2020_scout.roomDatabase.Match;
import com.example.a5846_2020_scout.roomDatabase.MatchDAO;

import android.content.Intent;

import org.parceler.Parcels;

public class MatchActivityReview extends AppCompatActivity implements MatchDAO
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_pracscore);
        final Match recording = Parcels.unwrap(getIntent().getParcelableExtra("MatchFromEnd"));
        final Intent returnToMain = new Intent(getApplicationContext(), MainActivity.class);

        Button menuSelect = findViewById(R.id.menuButton);
        TextView autoScore = findViewById(R.id.autoScore);
        TextView teleScore = findViewById(R.id.teleScore);
        TextView endScore = findViewById(R.id.endScore);
        TextView totalScore = findViewById(R.id.totalScore);

        autoScore.setText(Integer.toString(recording.autoScore()));
        teleScore.setText(Integer.toString(recording.teleScore()));
        endScore.setText(Integer.toString(recording.endScore()));
        totalScore.setText(Integer.toString(recording.totalScore()));

        menuSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                insert(recording);
                startActivity(returnToMain);
            }
        });
    }

    @Override
    public void insert(Match... Match) {

    }

    @Override
    public void update(Match... Match) {

    }

    @Override
    public void delete(Match Match) {

    }
}

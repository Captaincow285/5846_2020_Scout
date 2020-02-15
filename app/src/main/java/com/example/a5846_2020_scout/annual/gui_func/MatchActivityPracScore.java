package com.example.a5846_2020_scout.annual.gui_func;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.annual.PracticeMatch;
import com.example.a5846_2020_scout.common.MainActivity;

import org.parceler.Parcels;

public class MatchActivityPracScore extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_pracscore);
        PracticeMatch practice = Parcels.unwrap(getIntent().getParcelableExtra("Practice Object"));
        final Intent returnToMain = new Intent(getApplicationContext(), MainActivity.class);

        Button menuSelect = findViewById(R.id.menuButton);
        TextView autoScore = findViewById(R.id.autoScore);
        TextView teleScore = findViewById(R.id.teleScore);
        TextView endScore = findViewById(R.id.endScore);
        TextView totalScore = findViewById(R.id.totalScore);

        autoScore.setText(Integer.toString(practice.autoScore()));
        teleScore.setText(Integer.toString(practice.teleScore()));
        endScore.setText(Integer.toString(practice.endScore()));
        totalScore.setText(Integer.toString(practice.totalScore()));

        menuSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(returnToMain);
            }
        });
    }
}

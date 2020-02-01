package com.example.a5846_2020_scout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MatchActivityPre extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceStat) {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_match_pre);
        Log.d("Working", "MatchActivityPre Works!");
        final Intent returnToMain = new Intent(getApplicationContext(), MainActivity.class);

        final Switch pracToggle = findViewById(R.id.pracToggle);
        Button preScoutSubmit = findViewById(R.id.prematchSubmitButton);
        Button returnButton = findViewById(R.id.returnButton);
        final TextView matchNumBox = findViewById(R.id.matchNumBox);
        final EditText matchNumInput = findViewById(R.id.matchNumberInput);
        final TextView scoutInitialsBox = findViewById(R.id.scoutInitialsBox);
        final EditText initialsInput = findViewById(R.id.initialsInput);
        final TextView pracModeText = findViewById(R.id.pracModeText);
        final TextView pracModeText2 = findViewById(R.id.pracModeText2);
        final TextView teamNumBox = findViewById(R.id.teamNumBox);
        final EditText teamNumInput = findViewById(R.id.teamNumberInput);

        final Toast noGo = Toast.makeText(getApplicationContext(), "Fields not filled.", Toast.LENGTH_LONG);
        //Intent teleOp = new Intent(getApplicationContext(), );

        pracModeText.setVisibility(View.GONE);
        pracModeText2.setVisibility(View.GONE);

        pracToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    matchNumBox.setVisibility(View.GONE);
                    matchNumInput.setVisibility(View.GONE);
                    scoutInitialsBox.setVisibility(View.GONE);
                    initialsInput.setVisibility(View.GONE);
                    teamNumBox.setVisibility(View.GONE);
                    teamNumInput.setVisibility(View.GONE);
                    pracModeText.setVisibility(View.VISIBLE);
                    pracModeText2.setVisibility(View.VISIBLE);
                }
                else
                {
                    matchNumBox.setVisibility(View.VISIBLE);
                    matchNumInput.setVisibility(View.VISIBLE);
                    scoutInitialsBox.setVisibility(View.VISIBLE);
                    initialsInput.setVisibility(View.VISIBLE);
                    teamNumBox.setVisibility(View.VISIBLE);
                    teamNumInput.setVisibility(View.VISIBLE);
                    pracModeText.setVisibility(View.GONE);
                    pracModeText2.setVisibility(View.GONE);
                }
            }
        });

        preScoutSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(pracToggle.isChecked())
                {
                    setContentView(R.layout.activity_match_auto);
                }
                else
                {
                    boolean matchNumFilled = !matchNumInput.getText().toString().isEmpty();
                    boolean scoutInitFilled = !initialsInput.getText().toString().isEmpty();
                    boolean teamNumFilled = !teamNumInput.getText().toString().isEmpty();
                    if(scoutInitFilled && matchNumFilled && teamNumFilled)
                    {
                        String scoutInit = initialsInput.getText().toString();
                        int matchNumber = Integer.parseInt(matchNumInput.getText().toString());
                        int teamNum = Integer.parseInt(teamNumInput.getText().toString());


                    }
                    else
                    {
                        noGo.show();
                    }
                }
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(returnToMain);
            }
        });
    }
}
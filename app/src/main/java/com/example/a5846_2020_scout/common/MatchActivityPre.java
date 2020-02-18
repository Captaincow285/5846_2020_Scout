package com.example.a5846_2020_scout.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.annual.gui_func.MatchActivityAuto;


import org.parceler.Parcels;

import com.example.a5846_2020_scout.roomDatabase.Match;

public class MatchActivityPre extends AppCompatActivity {
    private String comp;

    protected void onCreate(Bundle savedInstanceStat) {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_match_pre);
        Log.d("Working", "MatchActivityPre Works!");
        final Intent returnToMain = new Intent(getApplicationContext(), MainActivity.class);
        final Intent auto = new Intent(getApplicationContext(), MatchActivityAuto.class);

        final Switch pracToggle = findViewById(R.id.pracToggle);
        Button preScoutSubmit = findViewById(R.id.prematchSubmitButton);
        Button returnButton = findViewById(R.id.returnButton);
        //Button confirmationSubmit = findViewById(R.id)

        final TextView matchNumBox = findViewById(R.id.matchNumBox);
        final EditText matchNumInput = findViewById(R.id.matchNumberInput);
        final TextView scoutInitialsBox = findViewById(R.id.scoutInitialsBox);
        final EditText initialsInput = findViewById(R.id.initialsInput);
        final TextView pracModeText = findViewById(R.id.pracModeText);
        final TextView pracModeText2 = findViewById(R.id.pracModeText2);
        final TextView teamNumBox = findViewById(R.id.teamNumBox);
        final EditText teamNumInput = findViewById(R.id.teamNumberInput);
        final ConfirmationDialog nextTask = new ConfirmationDialog();

        final int compIDSEM = 99800;
        final int compIDWPI = 99801;
        final int compIDDCMP = 99802;
        final int compIDWorld = 99803;
        final int compIDBattle = 99804;
        final int compIDBean = 99805;

        RadioButton sem = findViewById(R.id.compSEM);
        RadioButton wpi = findViewById(R.id.compWPI);
        RadioButton dcmp = findViewById(R.id.compNEDCMP);
        RadioButton world = findViewById(R.id.compWorlds);
        RadioButton battlecry = findViewById(R.id.compBattle);
        RadioButton beanBlitz = findViewById(R.id.compBean);
        final RadioGroup compSelect = findViewById(R.id.compSelectList);

        sem.setId(compIDSEM);
        wpi.setId(compIDWPI);
        dcmp.setId(compIDDCMP);
        world.setId(compIDWorld);
        battlecry.setId(compIDBattle);
        beanBlitz.setId(compIDBean);

        final Toast noGo = Toast.makeText(getApplicationContext(), "Fields not filled.", Toast.LENGTH_LONG);

        /*
        String[] competitions = {"SEMass", "WPI", "NEDCMP", "Worlds", "Battlecry", "Beantown Blitz"};
        final Spinner compSet = findViewById(R.id.comp_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_match_pre, R.id.competitionBox, competitions);
        compSet.setAdapter(adapter);
         */

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
                boolean practiceMode = pracToggle.isChecked();
                if(practiceMode)
                {
                    auto.putExtra("Practice Mode", practiceMode);
                    startActivity(auto);
                }
                else
                {
                    boolean matchNumFilled = !matchNumInput.getText().toString().isEmpty();
                    boolean scoutInitFilled = !initialsInput.getText().toString().isEmpty();
                    boolean teamNumFilled = !teamNumInput.getText().toString().isEmpty();

                    if(scoutInitFilled && matchNumFilled && teamNumFilled)
                    {
                        int x = compSelect.getCheckedRadioButtonId();
                        if(x == compIDSEM)
                        {
                            comp = "SE Mass";
                        }
                        else if(x == compIDWPI)
                        {
                            comp = "WPI";
                        }
                        else if(x == compIDDCMP)
                        {
                            comp = "NEDCMP";
                        }
                        else if(x == compIDWorld)
                        {
                            comp = "Worlds";
                        }
                        else if(x == compIDBattle)
                        {
                            comp = "Battlecry";
                        }
                        else if(x == compIDBean)
                        {
                            comp = "Beantown Blitz";
                        }

                        String scoutInit = initialsInput.getText().toString();
                        int matchNumber = Integer.parseInt(matchNumInput.getText().toString());
                        int teamNum = Integer.parseInt(teamNumInput.getText().toString());

                        Match recording = new Match();
                        recording.setCompetition(comp);
                        recording.setMatchNum(matchNumber);
                        recording.setTeamNumber(teamNum);
                        recording.setScoutInit(scoutInit);
                        auto.putExtra("MatchFromPre", Parcels.wrap(recording));
                        auto.putExtra("Practice Mode", practiceMode);
                        startActivity(auto);
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

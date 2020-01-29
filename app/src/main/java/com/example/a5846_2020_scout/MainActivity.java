package com.example.a5846_2020_scout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent option1 = new Intent(getApplicationContext(), MatchActivityDef.class);

        int sel1Id = 10011;
        int sel2Id = 10012;
        int sel3Id = 10013;
        int sel4Id = 10014;
        RadioButton initSel1 = findViewById(R.id.initSel1);
        initSel1.setId(sel1Id);
        RadioButton initSel2 = findViewById(R.id.initSel2);
        initSel2.setId(sel2Id);
        RadioButton initSel3 = findViewById(R.id.initSel3);
        initSel3.setId(sel3Id);
        RadioButton initSel4 = findViewById(R.id.initSel4);
        initSel4.setId(sel4Id);

        Button firstExec = findViewById(R.id.initExecButton);
        firstExec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RadioGroup firstSet = findViewById(R.id.initSelectGroup);
                int radioSelect = firstSet.getCheckedRadioButtonId();
                if(!(radioSelect == -1))
                {
                    Log.d("Working", "Filled RadioButton");
                    if(radioSelect == 10011)
                    {
                        startActivity(option1);
                    }
                    else if(radioSelect == 10012)
                    {
                        Log.d("Unimplemented", "Set Competition Selected");
                    }
                    else if(radioSelect == 10013)
                    {
                        Log.d("Unimplemented","Download Data to PC Selected");
                    }
                    else if(radioSelect == 10014)
                    {
                        Log.d("Unimplemented","How to Use This App Selected");
                    }
                }
            }
        });

    }
}

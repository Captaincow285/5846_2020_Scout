package com.example.a5846_2020_scout.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.example.a5846_2020_scout.R;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent option1 = new Intent(getApplicationContext(), MatchActivityPre.class);
        final Intent option2 = new Intent(getApplicationContext(), ExportActivity.class);

        final int sel1Id = 10011;
        final int sel2Id = 10013;
        RadioButton initSel1 = findViewById(R.id.initSel1);
        initSel1.setId(sel1Id);
        RadioButton initSel2 = findViewById(R.id.initSel2);
        initSel2.setId(sel2Id);

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
                    if(radioSelect == sel1Id)
                    {
                        String comp = Parcels.unwrap(getIntent().getParcelableExtra("compSet"));
                        option1.putExtra("compSet", Parcels.wrap(comp));
                        option1.putExtra("compName", getIntent().getParcelableExtra("compName"));
                        startActivity(option1);
                    }
                    else if(radioSelect == sel2Id)
                    {
                        Log.d("Unimplemented","Download Data to PC Selected");
                        startActivity(option2);
                    }
                }
            }
        });

    }
}

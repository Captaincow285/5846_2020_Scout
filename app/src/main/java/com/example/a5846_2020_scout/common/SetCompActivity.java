package com.example.a5846_2020_scout.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;

import org.parceler.Parcels;

public class SetCompActivity extends AppCompatActivity
{
    private String comp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setcomp);
        final Intent returnToMain = new Intent(getApplicationContext(), MainActivity.class);

        final int compIDSEM = 99900;
        final int compIDWPI = 99901;
        final int compIDDCMP = 99902;
        final int compIDWorld = 99903;
        final int compIDBattle = 99904;
        final int compIDBean = 99905;

        RadioButton sem = findViewById(R.id.compSEM);
        RadioButton wpi = findViewById(R.id.compWPI);
        RadioButton dcmp = findViewById(R.id.compNEDCMP);
        RadioButton world = findViewById(R.id.compWorlds);
        RadioButton battlecry = findViewById(R.id.compBattle);
        RadioButton beanBlitz = findViewById(R.id.compBean);
        final RadioGroup compSelect = findViewById(R.id.compSelectList);
        Button submit = findViewById(R.id.SubmitButton);

        sem.setId(compIDSEM);
        wpi.setId(compIDWPI);
        dcmp.setId(compIDDCMP);
        world.setId(compIDWorld);
        battlecry.setId(compIDBattle);
        beanBlitz.setId(compIDBean);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                returnToMain.putExtra("compName", Parcels.wrap(comp));
                returnToMain.putExtra("compSet", true);
                startActivity(returnToMain);
            }
        });

    }
}

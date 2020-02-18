package com.example.a5846_2020_scout.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.roomDatabase.MatchDatabase;

import java.io.File;

public class ExportActivity extends AppCompatActivity
{
    protected void onCreate(Bundle SavedInstanceStat) {
        super.onCreate(SavedInstanceStat);
        setContentView(R.layout.activity_export);
        final Intent returnMain = new Intent(getApplicationContext(), MainActivity.class);

        ProgressBar progress = findViewById(R.id.progressBar);
        final TextView updateNews = findViewById(R.id.updateText);
        final Button cancel = findViewById(R.id.cancelButton);
        final Button submit = findViewById(R.id.submitButton);
        final String[] updates = {"Creating Duplicate", "Getting Database", "Copying Data", "Deleting Original", "Closing"};

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(returnMain);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                //String fileName = "Export" + "_" + ;

                updateNews.setText(updates[0]);
                File duplicate = new File("/storage/sdcard0/Download" + "");
                //  /storage/sdcard0/Download
                //  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

                //  /storage/sdcard0/Android/data/package/files/Download
                //  getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)

                getDatabasePath("MatchDatabase");

            }
        });
    }
}

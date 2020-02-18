package com.example.a5846_2020_scout.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.a5846_2020_scout.R;
import com.example.a5846_2020_scout.roomDatabase.MatchDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class ExportActivity extends AppCompatActivity
{
    protected void onCreate(Bundle SavedInstanceStat) {
        super.onCreate(SavedInstanceStat);
        setContentView(R.layout.activity_export);
        final Intent returnMain = new Intent(getApplicationContext(), MainActivity.class);

        final ProgressBar progress = findViewById(R.id.progressBar);
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
                String fileName = "Export" + "_" + DateFormat.getDateInstance().toString() + ".db";

                updateNews.setText(updates[0]);
                progress.setProgress(1);
                File duplicate = new File("/storage/sdcard0/Download/" + fileName);
                //  /storage/sdcard0/Download
                //  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

                //  /storage/sdcard0/Android/data/package/files/Download
                //  getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)

                updateNews.setText(updates[1]);
                progress.setProgress(2);
                File original = new File(getDatabasePath("MatchDatabase").getAbsolutePath());

                updateNews.setText(updates[2]);
                progress.setProgress(3);
                FileChannel sourceChannel = null;
                FileChannel destChannel = null;
                try {
                    sourceChannel = new FileInputStream(original).getChannel();
                    destChannel = new FileOutputStream(duplicate).getChannel();
                    destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try {
                        sourceChannel.close();
                        destChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                updateNews.setText(updates[3]);
                progress.setProgress(4);
                original.delete();

                updateNews.setText(updates[4]);
                progress.setProgress(5);
                startActivity(returnMain);
            }
        });
    }
}

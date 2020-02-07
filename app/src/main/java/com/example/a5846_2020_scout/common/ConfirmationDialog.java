package com.example.a5846_2020_scout.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.example.a5846_2020_scout.BooleanPasser;

public class ConfirmationDialog extends DialogFragment
{
    public BooleanPasser confirmMessageBoolean = new BooleanPasser();

    public Dialog confirmation(Bundle savedInstanceState)
    {

        AlertDialog.Builder confirmMessage = new AlertDialog.Builder(getActivity());
        confirmMessage.setMessage("Are you sure this data is accurate?");
        confirmMessage.setPositiveButton("Yes, Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                confirmMessageBoolean.setXTrue();
            }
        });
        confirmMessage.setNegativeButton("No, Return to Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                confirmMessageBoolean.setXFalse();
            }
        });
        return confirmMessage.create();
    }
}

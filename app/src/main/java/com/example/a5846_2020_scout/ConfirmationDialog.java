package com.example.a5846_2020_scout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class ConfirmationDialog extends DialogFragment
{
    public Dialog confirmation(Bundle savedInstanceState)
    {
        AlertDialog.Builder confirmMessage = new AlertDialog.Builder(getActivity());
        confirmMessage.setMessage("Are you sure this data is accurate?");
        confirmMessage.setPositiveButton("Yes, Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        confirmMessage.setNegativeButton("No, Return to Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        return confirmMessage.create();
    }
}

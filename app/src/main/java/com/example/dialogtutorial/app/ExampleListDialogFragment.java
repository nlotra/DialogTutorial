package com.example.dialogtutorial.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Guest on 2014/07/02.
 */
public class ExampleListDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] colours = {"Red", "Green", "Blue"};

        //use Builder class to construct dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a Colour")
                .setItems(colours, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getBaseContext(), colours[i] + " clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        //create and return AlertDialog object
        return builder.create();
    }
}

package com.example.dialogtutorial.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Guest on 2014/07/02.
 */
public class ExampleMultichoiceListItem extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ArrayList <Integer> selectedItems = new ArrayList <Integer>();

        final String[] toppings = {"Onion", "Lettuce", "Tomato"};

        //use Builder class to construct dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a Colour")
                //set options to be shown
                .setMultiChoiceItems(toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b) {
                            //if the item is checked, add it to the selected items
                            selectedItems.add(i);
                        } else if (selectedItems.contains(i)) {
                            //if the item is already in the array, remove it
                            selectedItems.remove(Integer.valueOf(i));
                        }
                    }
                })
                //set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int j = 0; j < selectedItems.size(); j++)
                        {
                            Toast.makeText(getActivity().getBaseContext(), toppings[selectedItems.get(j)], Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        //create and return AlertDialog object
        return builder.create();
    }
}
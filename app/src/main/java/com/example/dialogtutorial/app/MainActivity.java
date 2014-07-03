package com.example.dialogtutorial.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        //create the options array
        String[] options = new String[] {"Fire missiles", "Pick a colour", "Pick toppings", "Log in", "Custom activity dialog"};

        //set the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onGo(View v) {
        DialogFragment dialog = null;
        String tag = "";
        switch(spinner.getSelectedItemPosition())
        {
            case 0:
                dialog = new FireMissilesDialogFragment();
                tag = "missiles";
                break;
            case 1:
                dialog = new ExampleListDialogFragment();
                tag = "colours";
                break;
            case 2:
                dialog = new ExampleMultichoiceListItem();
                tag = "toppings";
                break;
            case 3:
                dialog = new CustomSigninDialogFragment();
                tag = "signin";
                break;
            case 4:
                Intent i = new Intent(this, CustomDialogActivity.class);
                i.putExtra("message", "Choose an option");
                startActivity(i);
                break;
            default:
                Toast.makeText(getBaseContext(), "Please select an item", Toast.LENGTH_SHORT).show();
                break;
        }
        if(dialog != null) {
            dialog.show(getSupportFragmentManager(), tag);
        }
    }

}

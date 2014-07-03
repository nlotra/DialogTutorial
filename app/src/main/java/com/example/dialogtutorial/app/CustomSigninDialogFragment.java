package com.example.dialogtutorial.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Guest on 2014/07/03.
 */
public class CustomSigninDialogFragment extends DialogFragment {
    TextView username;
    TextView password;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //use Builder class to construct dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //inflate and set the layout for the dialog
        //pass null as parent view because it is going in dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_signin, null))
                //add action buttons
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onSignIn();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                        CustomSigninDialogFragment.this.getDialog().cancel();
                    }
                });
        //create and return AlertDialog object
        return builder.create();
    }

    public void onSignIn()
    {
        username = (TextView) getDialog().findViewById(R.id.username);
        password = (TextView) getDialog().findViewById(R.id.password);

        Toast.makeText(getActivity().getBaseContext(), username.getText().toString().trim(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity().getBaseContext(), password.getText().toString().trim(), Toast.LENGTH_SHORT).show();
    }
}
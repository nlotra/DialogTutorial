package com.example.dialogtutorial.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Guest on 2014/07/03.
 */
public class CustomDialogActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity_example);

        Button btnOk = (Button) findViewById(R.id.btn_ok);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        TextView dialogMsg = (TextView) findViewById(R.id.custom_dialog_msg);

        final Activity activity = this;

        Intent i = getIntent();
        String message = i.getStringExtra("message");
        dialogMsg.setText(message);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "OK clicked", Toast.LENGTH_SHORT).show();
                activity.finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                activity.finish();
            }
        });
    }
}

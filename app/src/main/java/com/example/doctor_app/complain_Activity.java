package com.example.doctor_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class complain_Activity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String etphone;
    EditText etMessage;
    Button btsend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_complain);

        etMessage = findViewById(R.id.msgContent);
        btsend = findViewById(R.id.btnSendSMS);
        etphone = "0626560698";

        btsend.setOnClickListener(new View.OnClickListener() {
            //check condition
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(complain_Activity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendMessage();
                    //when permission is granted
                    //create a method
                } else {
                    // when permission is not granted
                    // Request permission
                    ActivityCompat.requestPermissions(complain_Activity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }
    private void sendMessage() {
        //Get value from edit text
        String sPhone = etphone;
        String sMessage = etMessage.getText().toString().trim();

        //check condition
        if (!sPhone.equals("") && !sMessage.equals("")) {
            // when both edit text value not equal to blank
            // initalize sms manager
            SmsManager smsManager = SmsManager.getDefault();
            //Send text message
            smsManager.sendTextMessage(sPhone, null, sMessage, null, null);
            //Display toost
            Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_LONG).show();
        } else {
            //when edit text value is blank
            //Display toast
            Toast.makeText(getApplicationContext(), "Enter value first.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //check condition
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //when permission is granted
            //call method
            sendMessage();
        } else {
            // when permission is denied
            // Display toast
            Toast.makeText(getApplicationContext(), "Permission Denied!", Toast.LENGTH_SHORT).show();
        }
    }
    public void homehandle(View v){
        Intent intent = new Intent(complain_Activity.this, Setting_Activity.class);
        startActivity(intent);
    }
}
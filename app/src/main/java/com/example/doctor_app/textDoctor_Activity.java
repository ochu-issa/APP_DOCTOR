package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class textDoctor_Activity extends AppCompatActivity {

//    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
//    String phoneNum;
//    EditText Message;
//    String phoneNo;
//    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        phoneNum = "0652762026";
//        Message = findViewById(R.id.msgContent);
    }

//    public void sendMsg(View view) {
//        phoneNo = phoneNum;
//        message = Message.getText().toString();
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.SEND_SMS)) {
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.SEND_SMS},
//                        MY_PERMISSIONS_REQUEST_SEND_SMS);
//            }
//        }
//    }

    public void homehandle(View v){
        Intent intent = new Intent(textDoctor_Activity.this, doctor_details_activity.class);
        startActivity(intent);
    }
}
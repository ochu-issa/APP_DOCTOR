package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Setting_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);
    }
    public void homehandle(View v){
        Intent intent = new Intent(Setting_Activity.this, Dashboard_Activity.class);
        startActivity(intent);
    }
    public void sendmsg(View v){
        Intent intent = new Intent(Setting_Activity.this, Sending_Message_Activity.class);
        startActivity(intent);
    }
    public void feedbackhandle(View v){
        Intent intent = new Intent(Setting_Activity.this, Feedback_Activity.class);
        startActivity(intent);
    }
    public void gotopolicy(View v){
        Intent intent = new Intent(Setting_Activity.this, Privacy_policy_Activity.class);
        startActivity(intent);
    }
    public void gotoprofile(View v){
        Intent intent = new Intent(Setting_Activity.this, Profile_activity.class);
        startActivity(intent);
    }
    public void gotocomplain(View v){
        Intent intent = new Intent(Setting_Activity.this, complain_Activity.class);
        startActivity(intent);
    }
}
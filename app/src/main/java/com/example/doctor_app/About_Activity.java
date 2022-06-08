package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class About_Activity extends AppCompatActivity {
    ImageView btcall;
    String etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);

        etNumber = "0626560698";
        btcall = findViewById(R.id.btCall);

        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone =  etNumber;
                String s = "tel:" + phone;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                startActivity(intent);
            }
        });

    }
    public void backhome(View v){
        Intent intent = new Intent(About_Activity.this, Dashboard_Activity.class);
        startActivity(intent);
    }

    public void gotTomsg(View v){
        Intent intent = new Intent(About_Activity.this, Doctor_text_Activity.class);
        startActivity(intent);
    }
}
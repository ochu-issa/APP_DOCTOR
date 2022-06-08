package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class doctor_details_activity extends AppCompatActivity {
    ImageView btcall;
    String etNumber;
    Button appointmentBTN;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_details);

        etNumber = "0626560698";
        btcall = findViewById(R.id.btCall);
        dialog = new Dialog(this);


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


        appointmentBTN = findViewById(R.id.appointment);
        appointmentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWinDialog();
            }
        });
    }

    private void openWinDialog() {
        dialog.setContentView(R.layout.win_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageviewClose =dialog.findViewById(R.id.imageViewClose);
        Button btnOK = dialog.findViewById(R.id.btnOK);

        imageviewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(doctor_details_activity.this, "Dialog Close", Toast.LENGTH_SHORT).show();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(doctor_details_activity.this, "Button Ok", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    public void handletoseeall(View v){
        Intent intent = new Intent(doctor_details_activity.this, see_more_activity.class);
        startActivity(intent);
    }
    public void sendmsg(View v){
        Intent intent = new Intent(doctor_details_activity.this, Doctor_text_Activity.class);
        startActivity(intent);
    }
}
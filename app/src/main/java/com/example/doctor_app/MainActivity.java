package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button logibt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //setTitle("Home");

        TextView uname = findViewById(R.id.username);
        TextView pwd = findViewById(R.id.password);

        MaterialButton logibt =  findViewById(R.id.loginbtn);

        logibt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString();
                String pass = pwd.getText().toString();
                if(username.isEmpty()){
                    uname.setError("Field required!");
                }
                if(pass.isEmpty()){
                    pwd.setError("Field required!");
                }else{
                    try {
                        if(isConnect()){
                            if (uname.getText().toString().equals("admin") && pwd.getText().toString().equals("admin")){
                                //correct
                                Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Dashboard_Activity.class);
                                startActivity(intent);


                            }else{
                                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                
            }
        });

    }
    public void forgotpwdHandle(View v){
        Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void registerhandle(View v){
        Intent intent = new Intent(MainActivity.this, Registration_Activity.class);
        startActivity(intent);
    }
    
    public boolean isConnect() throws InterruptedException, IOException {
        String command = "ping -c 1 google.com";
        return
                Runtime.getRuntime().exec(command).waitFor() == 0;

    }
}
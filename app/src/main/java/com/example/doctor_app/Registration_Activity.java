package com.example.doctor_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Registration_Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView banner,  registerUser;
    private EditText editTextFullName, editTextEmail, editTextPwd1;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.fullname);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPwd1 = (EditText) findViewById(R.id.pwd);
//        TextView uname = findViewById(R.id.username);
//        TextView email = findViewById(R.id.email);
//        TextView pwd = findViewById(R.id.pwd);
//        TextView pwd2 = findViewById(R.id.pwd2);
//
//        MaterialButton signUp =  findViewById(R.id.loginbtn);
//
//        signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = uname.getText().toString();
//                String mail = email.getText().toString();
//                String pass = pwd.getText().toString();
//                String pass2 = pwd2.getText().toString();
//
//                if(username.isEmpty()){
//                    uname.setError("This field is required!");
//                }
//                if(mail.isEmpty()){
//                    email.setError("This field is required!");
//                }
//                if(pass.isEmpty()){
//                    pwd.setError("This field is required!");
//                }
//                if(pass2.isEmpty()){
//                    pwd2.setError("This field is required!");
//                } else{
//                    if(pass != pass2){
//                        pwd.setError("Password didn't match!");
//                    }else{
//                        Intent intent = new Intent(Registration_Activity.this, Congratulate_Activity.class);
//                        startActivity(intent);
//                    }
//                }
//            }
//        });
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

    }
    public void backhandle(View v){
        Intent intent = new Intent(Registration_Activity.this, Congratulate_Activity.class);
        startActivity(intent);
    }
    public void login_handle(View v){
        Intent intent = new Intent(Registration_Activity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;

        }

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPwd1.getText().toString().trim();
        String fullname = editTextFullName.getText().toString().trim();

        if(fullname.isEmpty()){
            editTextFullName.setError("Full name is required!");
            editTextFullName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPwd1.setError("Password is required!");
            editTextPwd1.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextPwd1.setError("Min password lenth should be 6 characters!");
            editTextPwd1.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(fullname, email);

                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Registration_Activity.this, "user has been registered successfully", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }else{
                                        Toast.makeText(Registration_Activity.this, "failed to register! try again", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }else{
                            Toast.makeText(Registration_Activity.this, "failed to register!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}
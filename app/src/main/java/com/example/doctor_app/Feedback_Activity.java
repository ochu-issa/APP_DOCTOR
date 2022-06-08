package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback_Activity extends AppCompatActivity {

    Button button;
    RatingBar ratingStar;
    float MyRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feedback);

        button = findViewById(R.id.button);
        ratingStar = findViewById(R.id.ratingbar);

        ratingStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;

                MyRating = (float) ratingBar.getRating();

                switch (rating){
                    case 1:
                        message = "Sorry to hear that :(";
                        break;
                    case 2:
                        message = "You always accept suggestions!";
                        break;
                    case 3:
                        message = "Good enough!";
                        break;
                    case 4:
                        message = "Great! thank you!";
                        break;
                    case 5:
                        message = "Awesome! you are the best!";
                        break;
                }
                Toast.makeText(Feedback_Activity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Feedback_Activity.this, "Your rating is: " + MyRating, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void homehandle(View v){
        Intent intent = new Intent(Feedback_Activity.this, Setting_Activity.class);
        startActivity(intent);

    }
}
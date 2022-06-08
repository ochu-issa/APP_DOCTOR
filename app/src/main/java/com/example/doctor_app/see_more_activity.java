package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

public class see_more_activity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerView;
   // private RecyclerView recyclerViewCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_see_more);

        recyclerView = findViewById(R.id.viewMostView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<MostlyViewedDomain> mostviewed =new ArrayList<>();
        mostviewed.add(new MostlyViewedDomain("Dr. Happy Alexander", "B.Medical Doctor, Mloganzila Hospital", "pic_1"));
        mostviewed.add(new MostlyViewedDomain("Dr. Salma Hassan Yahya", "Eyes Specialist, Mnazi M/Mojja Zanzibar", "pic_2"));
        mostviewed.add(new MostlyViewedDomain("Dr. Zainab Kairuki", "Heart Attack Specialist, KCMC Hospital;", "pic_3"));
        mostviewed.add(new MostlyViewedDomain("Dr. Jojet Manula", "Child Specialist, MD Muhimbili Hospital", "pic_1"));
        mostviewed.add(new MostlyViewedDomain("Dr. Zuhra I Ibrahim", "Foot Specialist, MD, Jeshini Hospital;", "pic_1"));
        mostviewed.add(new MostlyViewedDomain("Dr. Taadud K. Ramadhan", "B.Medical Doctor, Mloganzila Hospital", "pic_1"));
        mostviewed.add(new MostlyViewedDomain("Dr moza Abbas khamis", "Love Therapist, Mazizini Hospital", "pic_1"));
        mostviewed.add(new MostlyViewedDomain("Dr. Warydat james", "Operation Specialist, Muhimbili Hospital", "pic_1"));

        adapter=new MostViewAdapter(mostviewed);
        recyclerView.setAdapter(adapter);

    }
    public void homehandle(View v){
        Intent intent = new Intent(see_more_activity.this, Dashboard_Activity.class);
        startActivity(intent);
    }
    public void doctordetail(View v){
        Intent intent = new Intent(see_more_activity.this, doctor_details_activity.class);
        startActivity(intent);
    }
}
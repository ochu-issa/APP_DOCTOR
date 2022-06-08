package com.example.doctor_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Switch;

import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewCat;

    //variable
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar= findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

       //
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = findViewById(R.id.viewMostView);
        recyclerViewCat = findViewById(R.id.viewCategory);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewCat.setLayoutManager(linearLayoutManager2);

        ArrayList<CategoryDomain> cat = new ArrayList<>();
        cat.add(new CategoryDomain("Cancer", "ribbon"));
        cat.add(new CategoryDomain("Heart Attack", "heart"));
        cat.add(new CategoryDomain("Foot injury", "sprained"));
        cat.add(new CategoryDomain("Eyes problem", "eye"));

        adapter2 = new CategoryAdapter(cat);
        recyclerViewCat.setAdapter(adapter2);

        ArrayList<MostlyViewedDomain> mostviewed =new ArrayList<>();
        mostviewed.add(new MostlyViewedDomain("Dr. Happy Alexander", "B.Medical Doctor, Mloganzila Hospital", "pic_1"));
        mostviewed.add(new MostlyViewedDomain("Dr. Salma Hassan Yahya", "Eyes Specialist, Mnazi M/Mojja Zanzibar", "pic_2"));
        mostviewed.add(new MostlyViewedDomain("Dr. Zainab Kairuki", "Heart Attack Specialist, KCMC Hospital;", "pic_3"));
        mostviewed.add(new MostlyViewedDomain("Dr. Jojet Manula", "Child Specialist, MD Muhimbili Hospital", "pic_1"));

        adapter=new MostViewAdapter(mostviewed);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START) ){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    public void seeallhandle(View v){
        Intent intent = new Intent(Dashboard_Activity.this, see_more_activity.class);
        startActivity(intent);
    }

    public void doctordetail(View v){
        Intent intent = new Intent(Dashboard_Activity.this, doctor_details_activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_myAccount:
                Intent intent = new Intent(Dashboard_Activity.this, Profile_activity.class);
                startActivity(intent);
                break;
            case R.id.nav_specialist:
                Intent v = new Intent(Dashboard_Activity.this, Specialist_Activity.class);
                startActivity(v);
                break;
            case R.id.nav_setting:
                Intent s = new Intent(Dashboard_Activity.this, Setting_Activity.class);
                startActivity(s);
                break;
            case R.id.nav_logout:
                Intent l = new Intent(Dashboard_Activity.this,  MainActivity.class);
                startActivity(l);
                break;
            case R.id.nav_about:
                Intent a = new Intent(Dashboard_Activity.this,  ContactUs_Activity.class);
                startActivity(a);
                break;
            case R.id.nav_contact:
                Intent c = new Intent(Dashboard_Activity.this,  About_Activity.class);
                startActivity(c);
                break;
            case R.id.nav_help:
                Intent h = new Intent(Dashboard_Activity.this,  help_Activity.class);
                startActivity(h);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out our Doctor App \n Thanks for your sharing.");
//        intent.putExtra(intent.EXTRA_TEXT, "Download here: https//www.doctorA" +
//                "pp.co//download/appstore?");
//        startActivity(Intent.createChooser(intent, "Share Via"));
//        return super.onOptionsItemSelected(item);
//    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Workout extends AppCompatActivity {

    HelperDB helperDB;
    SQLiteDatabase db;
    Button bAddExercise,bViewDataEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        helperDB=new HelperDB(this);
        db=helperDB.getWritableDatabase();
        db.close();

        bAddExercise=findViewById(R.id.bAddExercise);
        bAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Workout.this, insertExercise.class);
                startActivity(intent);
            }
        });


        bViewDataEx=findViewById(R.id.bViewDataEx);
        bViewDataEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Workout.this, ViewData.class);
                startActivity(intent);
            }
        });







    }



    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);

        if (menu instanceof MenuBuilder) {
            MenuBuilder mb = (MenuBuilder) menu;
            mb.setOptionalIconsVisible(true);
        }
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();

        if (itemID == R.id.profile) {
            Intent intent = new Intent(Workout.this, Profile.class);
            startActivity(intent);
        }
        if (itemID == R.id.discover) {
            Intent intent = new Intent(Workout.this, Discover.class);
            startActivity(intent);
        }
        if (itemID == R.id.exercises) {
            Intent intent = new Intent(Workout.this, Exercises.class);
            startActivity(intent);
        }
        if (itemID == R.id.aboutUs) {
            Intent intent = new Intent(Workout.this, AboutUs.class);
            startActivity(intent);
        }
        if (itemID == R.id.contactUs) {
            Intent intent = new Intent(Workout.this, ContactUs.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }




}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
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
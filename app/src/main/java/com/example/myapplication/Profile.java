package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.GravityCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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


        if (itemID == R.id.discover) {
            Intent intent = new Intent(Profile.this, Discover.class);
            startActivity(intent);
        }
        if (itemID == R.id.exercises) {
            Intent intent = new Intent(Profile.this, Exercises.class);
            startActivity(intent);
        }
        if (itemID == R.id.workout) {
            Intent intent = new Intent(Profile.this, Workout.class);
            startActivity(intent);
        }
        if (itemID == R.id.aboutUs) {
            Intent intent = new Intent(Profile.this, AboutUs.class);
            startActivity(intent);
        }
        if (itemID == R.id.contactUs) {
            Intent intent = new Intent(Profile.this, ContactUs.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);

    }

    public void showAlertDialog(View v){


            AlertDialog.Builder adb = new AlertDialog.Builder(Profile.this);
            adb.setTitle("Logout");
            adb.setMessage("Are you sure you want to logout from this account?");
            adb.setIcon(android.R.drawable.sym_def_app_icon);
            //adb.setCancelable(false);
            adb.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Profile.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    adb.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Profile.this, Profile.class);
                            startActivity(intent);
                        }
                    });
                    adb.create().show();

                }

        };


















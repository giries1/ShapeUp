package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Button BLoginFragment;
    Button BSignupFragment;
    FrameLayout flFragment;
    Context context;
    LoginFragment loginFragment;
    SignupFragment signupFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        BLoginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginFragment=new LoginFragment();
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragments,loginFragment);
                ft.commit();

            }
        });
        BSignupFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupFragment=new SignupFragment();
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragments,signupFragment);
                ft.commit();
            }
        });

    }

    private void initComponents() {
        BLoginFragment = findViewById(R.id.BLoginFragment);
        BSignupFragment = findViewById(R.id.BSignupFragment);
    }

}
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;


public class LoginFragment extends Fragment {
    FirebaseAuth mAuth= FirebaseAuth.getInstance();

    EditText TEmail, TPassword;
    Button BLogin;
    private String st1 ="",st2 ="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        TEmail=view.findViewById(R.id.TEmail);
        TPassword=view.findViewById(R.id.TPassword);
        BLogin=view.findViewById(R.id.BLogin);
        BLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st1 = TEmail.getText().toString();
                st2 = TPassword.getText().toString();
                final FirebaseAuth mAuth = FirebaseAuth.getInstance();

                mAuth.signInWithEmailAndPassword(TEmail.getText().toString(), TPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getActivity().getApplicationContext(),HomePage.class));

//                            FirebaseUser user = mAuth.getCurrentUser();
//                            String name = user.getDisplayName();
//                            Intent t = new Intent("com.example.haifaapp.custom.broadcast");
//                            t.putExtra("data", "Thank you for logged in " + name);
//
//                            startActivity(new Intent(getActivity().this, MainActivity.class));

                                } else {

                                    Log.d("error", "erro");

                                }
                            }

                        });
            }
        // Inflate the layout for this fragment

    });

     return view;
    }
}
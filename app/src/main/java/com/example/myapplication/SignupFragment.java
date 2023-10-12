package com.example.myapplication;

import static android.content.ContentValues.TAG;

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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragment} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {


    EditText TEmail1, TPassword1,PhoneNumber,Date;
    Button BSignup;
    TextView errorText;
    private String st1 ="",st2 ="",st3 ="",st4 ="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        TEmail1=view.findViewById(R.id.TEmail1);
        TPassword1=view.findViewById(R.id.TPassword1);
        PhoneNumber=view.findViewById(R.id.editTextPhone);
        Date=view.findViewById(R.id.editTextDate2);
        BSignup=view.findViewById(R.id.BSignup);
        errorText=view.findViewById(R.id.errorText);
        BSignup.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){
                    st1=TEmail1.getText().toString();
                    st2=TPassword1.getText().toString();
                    st3=PhoneNumber.getText().toString();
                    st4=Date.getText().toString();
                    errorText.setVisibility(View.GONE);
                    if(TEmail1.getText().toString().equals("")){
                        errorText.setVisibility(View.VISIBLE);
                        errorText.setText("please enter your full name");
                        return;
                    }
                    if(TPassword1.getText().toString().equals("")) {
                        errorText.setVisibility(View.VISIBLE);
                        errorText.setText("please enter your password");
                        return;
                    }
                    final FirebaseAuth mAuth=FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(TEmail1.getText().toString(), TPassword1.getText().toString())

                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(TEmail1.getText().toString())
                                                .build();

                                        user.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(requireContext(), "SignedUp successfully", Toast.LENGTH_SHORT).show();
                                                                    startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
                                                        }
                                                    }
                                                });
                                    } else {

                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        errorText.setVisibility(View.VISIBLE);
                                        errorText.setText(task.getException().getMessage());


                                    }
            };
        });

            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
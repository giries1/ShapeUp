package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertExercise extends AppCompatActivity {

    HelperDB hlp;
    SQLiteDatabase db;
    EditText exerciseNameEditText,setsEditText,repsEditText,weightEditText,restSecsEditText;
    String stExerciseName,stSets,stReps,stWeight,stRestTime;
    WorkoutPlan wp;
    int exSets;
    int exReps;
    int exRestTime;
    double exWeight;

    Button insertExerciseButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_exercise);

        exerciseNameEditText=findViewById(R.id.exerciseNameEditText);
        setsEditText=findViewById(R.id.setsEditText);
        repsEditText=findViewById(R.id.repsEditText);
        weightEditText=findViewById(R.id.weightEditText);
        restSecsEditText=findViewById(R.id.restSecsEditText);

        hlp = new HelperDB(getApplicationContext());
        db=hlp.getWritableDatabase();
        db.close();

        insertExerciseButton=findViewById(R.id.insertExerciseButton);
        insertExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insetExerciseData();

            }
        });

    }

public void insetExerciseData(){

        stExerciseName=exerciseNameEditText.getText().toString();
        stReps=repsEditText.getText().toString();
        stSets=setsEditText.getText().toString();
        stWeight=weightEditText.getText().toString();
        stRestTime=restSecsEditText.getText().toString();

        exSets=Integer.parseInt(stSets);
        exReps=Integer.parseInt(stReps);
        exRestTime=Integer.parseInt(stRestTime);
        exWeight=Double.parseDouble(stWeight);

        wp = new WorkoutPlan(stExerciseName,exSets,exReps,exWeight,exRestTime);

        hlp=new HelperDB(getApplicationContext());
        db=hlp.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(hlp.ExerciseName,wp.getExerciseName());
        cv.put(hlp.Reps,wp.getReps());
        cv.put(hlp.Sets,wp.getSets());
        cv.put(hlp.Weight,wp.getWeight());
        cv.put(hlp.RestSecs,wp.getRestSecs());
        db.insert(HelperDB.WorkoutPlan_Table,null,cv);
        db.close();
        exerciseNameEditText.setText("");
        restSecsEditText.setText("");
        repsEditText.setText("");
        weightEditText.setText("");
        setsEditText.setText("");

    Toast.makeText(this,"A new exercise have been added to your workout",Toast.LENGTH_LONG).show();



}







}
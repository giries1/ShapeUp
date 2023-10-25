package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {


    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static final String DB_FILE="workout_plans2.db";

    public static final String WorkoutPlan_Table="WorkoutPlan";//Table name

    public static final String ExerciseName="ExerciseName";
    public static final String Sets= "Sets" ;
    public static final String Reps="Reps";
    public static final String Weight="Weight";
    public static final String RestSecs="RestSecs";


    public HelperDB(Context context){
        super(context,DB_FILE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String st="CREATE TABLE IF NOT EXISTS "+WorkoutPlan_Table+" ( ";
        st+=ExerciseName+" TEXT, "+Sets+" INTEGER, "+Reps+" INTEGER, "+Weight+" REAL, "+RestSecs+" INTEGER);";
        db.execSQL(st);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

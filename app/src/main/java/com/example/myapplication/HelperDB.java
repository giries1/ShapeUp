package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {


    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
public HelperDB(Context context){
        super(context,DB_FILE,null,1);
}

    public static final String DB_FILE="myUserProfiles_info.db";

    public static final String userProfiles_Table="userProfiles";//Table name

    public static final String username="userProfiles_username";//username
    public static final String id="id";//id
    public static final String Age="age";//age
    public static final String Height="height";//height
    public static final String fitnessGoals="fitnessGoals";//fitnessGoals
    public static final String workoutPreferences="workoutPreferences";//workoutPreferences





    @Override
    public void onCreate(SQLiteDatabase db) {
       String st="CREATE TABLE IF NOT EXIST"+userProfiles_Table;
        st+= " ( " + username + "Text";
        st+=  Age + "INTEGER";
        st+=  id + "INTEGER";
        st+=  fitnessGoals + "Text";
        st+=  workoutPreferences +"Text";
        st+=  Height +"REAL";
        db.execSQL(st);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

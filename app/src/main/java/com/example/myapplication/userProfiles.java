package com.example.myapplication;

public class userProfiles {

    private int id;
    private String username;
    private int age;
    private double height;
    private String fitnessGoals;
    private String workoutPreferences;

    public userProfiles(int id,String username,int age,double height,String fitnessGoals,String workoutPreferences) {
        this.id = id;
        this.username=username;
        this.age=age;
        this.fitnessGoals=fitnessGoals;
        this.workoutPreferences=workoutPreferences;
        this.height=height;
        
    }

    public String getWorkoutPreferences() {
        return workoutPreferences;
    }

    public void setWorkoutPreferences(String workoutPreferences) {
        this.workoutPreferences = workoutPreferences;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

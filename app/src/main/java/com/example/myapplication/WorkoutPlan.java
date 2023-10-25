package com.example.myapplication;

public class WorkoutPlan {

    private String ExerciseName;
    private int sets;
    private int reps;
    private int restSecs;
    private double weight ;

    public int getRestSecs() {
        return restSecs;
    }

    public void setRestSecs(int restSecs) {
        this.restSecs = restSecs;
    }

    public WorkoutPlan(String ExerciseName, int sets, int reps, double weight, int restSecs) {

        this.ExerciseName=ExerciseName;
        this.sets=sets;
        this.reps=reps;
        this.weight=weight;
        this.restSecs=restSecs;

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public String getExerciseName() {
        return ExerciseName;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "ExerciseName='" + ExerciseName + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", restSecs=" + restSecs +
                ", weight=" + weight +
                '}';
    }
}


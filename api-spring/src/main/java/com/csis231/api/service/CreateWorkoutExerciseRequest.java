package com.csis231.api.service;

import java.util.Date;

public class CreateWorkoutExerciseRequest {

    private Long workoutId;
    private Long exerciseId;
    private Date date;
    private int reps;
    private int sets;

    public CreateWorkoutExerciseRequest() {
    }

    public CreateWorkoutExerciseRequest(Long workoutId, Long exerciseId, Date date, int reps, int sets) {
        this.workoutId = workoutId;
        this.exerciseId = exerciseId;
        this.date = date;
        this.reps = reps;
        this.sets = sets;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}

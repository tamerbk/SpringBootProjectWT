package com.csis231.api.model;

import java.util.Date;

public class WorkoutExerciseDTO {
    private Long id;
    private Long exercise_id;

    private Long workout_id;
    private int sets;
    private int reps;

    private int weight;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WorkoutExerciseDTO() {
    }

    public WorkoutExerciseDTO(Long id, Long exercise_id,Long workout_id, int sets, int reps, int weight) {
        this.id = id;
        this.exercise_id = exercise_id;
        this.sets = sets;
        this.reps = reps;
        this.workout_id=workout_id;
        this.weight=weight
                ;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Long workout_id) {
        this.workout_id = workout_id;
    }

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }


    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}


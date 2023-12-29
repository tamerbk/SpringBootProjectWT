package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "workout_Exercise")
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id")
  @JsonIgnore
    private workout Workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
  @JsonIgnore
    private Exercise exercise;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Column(name="c_sets")
    private int sets;

    @Column(name="weight",nullable = true)
    private int weightReached;
    @Column(name="c_reps")
    private int reps;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public workout getWorkout() {
        return Workout;
    }

    public void setWorkout(workout Workout) {
        this.Workout = Workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getWeightReached() {
        return weightReached;
    }

    public void setWeightReached(int weightReached) {
        this.weightReached = weightReached;
    }

    @Override
    public String toString() {
        String exerciseString = (exercise != null) ? exercise.toString() : null;
        String workoutString = (Workout != null) ? Workout.toString() : null;

        return "WorkoutExercise[" +
                "id=" + id +
                ", date=" + date +
                ", reps=" + reps +
                ", sets=" + sets +
                ", Exercise=" + exerciseString +
                ", workout=" + workoutString +
                ']';
    }


}

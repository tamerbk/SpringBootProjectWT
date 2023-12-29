package com.csis231.api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Exercise_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToMany(mappedBy = "exercise")
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

    @Column(name="Exercise_name", nullable = false)
    private String ExerciseName;
    @Column(name="Repetition")
    private int reps;
    @Column(name = "sets")
    private int sets;

    @Column(name = "Exercise_description")
    private String desc;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return ExerciseName;
    }

    public void setExerciseName(String Name) {
        this.ExerciseName = Name;
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



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return "Exercise [id=" +id+", ExerciseName=" +ExerciseName+ "Reps=" +reps+ "sets=" +sets+"desc=" +desc+ "]";
    }
}

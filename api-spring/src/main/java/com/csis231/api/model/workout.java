package com.csis231.api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="workout_id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "Workout")
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @NotEmpty
    @Column(name="date", nullable = false)
    private Date WDate;
    @Column(name="workout_name")
    private String WorkoutName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getWorkoutDate() {
        return WDate;
    }

    public void setWorkOutDate(Date date) {
        this.WDate = date;
    }

    public String getWorkoutName() {
        return WorkoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.WorkoutName = workoutName;
    }





    @Override
    public String toString()
    {
        return "workout [id=" +id+", WorkoutName=" +WorkoutName+ "WDate=" +WDate+  "]";
    }

}

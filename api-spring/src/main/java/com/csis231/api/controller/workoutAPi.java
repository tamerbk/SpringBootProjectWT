package com.csis231.api.controller;

//import com.google.gson.Gson;
import com.csis231.api.model.workout;
import com.csis231.api.service.workoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/v1/workout")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class workoutAPi {

    @Autowired
    private workoutService workoutService;


    @PostMapping("/Cid/{clientId}")
    public ResponseEntity<List<workout>> getAllWorkoutsByCId(@PathVariable("clientId") long clientId) {
        List<workout> workouts = workoutService.getWorkoutsByClientId(clientId);

        if (workouts.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(workouts);
        }
    }
  @PostMapping
  public ResponseEntity<workout>createWorkout(@RequestBody workout workout)
  {
      workout createdWorkout = workoutService.createWorkout(workout);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdWorkout);
  }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteworkout(id);
        return ResponseEntity.noContent().build();
    }


    }



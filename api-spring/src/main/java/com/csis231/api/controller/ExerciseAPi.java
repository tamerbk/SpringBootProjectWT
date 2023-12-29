package com.csis231.api.controller;

import com.csis231.api.model.Client;
import com.csis231.api.model.Exercise;
import com.csis231.api.repository.ExerciseRepository;
import com.csis231.api.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Exercise")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExerciseAPi {

    @Autowired
  private   ExerciseService exerciseService;

    @GetMapping("/byIds")
    public ResponseEntity<List<Exercise>> getExercisesByIds(@RequestParam List<Long> ids) {
        List<Exercise> exercises = exerciseService.getExercisesByIds(ids);
        return ResponseEntity.ok(exercises);
    }
    @PostMapping
    public ResponseEntity<Exercise> createExericise(@RequestBody Exercise exercise) {
        Exercise createdExercise = exerciseService.createExercise(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }

}

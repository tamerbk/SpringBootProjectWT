package com.csis231.api.controller;

import com.csis231.api.model.WorkoutExercise;
import com.csis231.api.model.WorkoutExerciseDTO;
import com.csis231.api.service.CreateWorkoutExerciseRequest;
import com.csis231.api.service.ExerciseService;
import com.csis231.api.service.WorkoutExerciseService;
import com.csis231.api.service.workoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/workoutExercise")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkoutExerciseAPi {

    @Autowired
    private WorkoutExerciseService workoutExerciseService;
    @Autowired
    private workoutService WorkoutService;
    @Autowired
    private ExerciseService exerciseService;


    public WorkoutExerciseAPi(WorkoutExerciseService workoutExerciseService) {
        this.workoutExerciseService = workoutExerciseService;
    }
    @GetMapping("/getByWorkoutId/{workoutId}")
    public ResponseEntity<List<Long>> getworkoutExercisebyWorkoutId(@PathVariable Long workoutId)
    {
        List<Long> workoutExercises = workoutExerciseService.findWorkoutExercisesByWorkoutId(workoutId);
  return ResponseEntity.ok(workoutExercises);
    }

    @PostMapping("/CreateWorkoutExercise")
    public ResponseEntity<WorkoutExerciseDTO> createWorkoutExercise(@RequestBody WorkoutExerciseDTO workoutExerciseDTO) {
        // Convert the DTO to the entity object
        WorkoutExercise workoutExercise = convertToEntity(workoutExerciseDTO);

        // Save the workout exercise in the backend
        WorkoutExercise savedWorkoutExercise = workoutExerciseService.save(workoutExercise);

        // Convert the saved entity object back to DTO
        WorkoutExerciseDTO savedWorkoutExerciseDTO = convertToDTO(savedWorkoutExercise);

        return ResponseEntity.ok(savedWorkoutExerciseDTO);
    }

    private WorkoutExercise convertToEntity(WorkoutExerciseDTO workoutExerciseDTO) {
        WorkoutExercise workoutExercise = new WorkoutExercise();

        // Set the properties of the entity object from the DTO
        workoutExercise.setId(workoutExerciseService.getMaxId()+1);
        workoutExercise.setWorkout(WorkoutService.getWorkoutById(workoutExerciseDTO.getWorkout_id()));
        workoutExercise.setExercise(exerciseService.getExerciseById(workoutExerciseDTO.getExercise_id()));
        workoutExercise.setDate(LocalDate.now());
        workoutExercise.setSets(workoutExerciseDTO.getSets());
        workoutExercise.setReps(workoutExerciseDTO.getReps());
        workoutExercise.setWeightReached(workoutExerciseDTO.getWeight());

        return workoutExercise;
    }
    private WorkoutExerciseDTO convertToDTO(WorkoutExercise workoutExercise) {
        WorkoutExerciseDTO workoutExerciseDTO = new WorkoutExerciseDTO();
        workoutExerciseDTO.setId(workoutExercise.getId());
        workoutExerciseDTO.setWorkout_id(workoutExercise.getWorkout().getId());
        workoutExerciseDTO.setExercise_id(workoutExercise.getExercise().getId());
        workoutExerciseDTO.setReps(workoutExercise.getReps());
        workoutExerciseDTO.setSets(workoutExercise.getSets());
        workoutExerciseDTO.setWeight(workoutExercise.getWeightReached());

        return workoutExerciseDTO;
    }

    @GetMapping("/latestWorkoutExercises/{workoutId}")
    public ResponseEntity<List<WorkoutExerciseDTO>> getLatestWorkoutExercisesByWorkoutId(@PathVariable("workoutId") long workoutId) {
        List<WorkoutExerciseDTO> workoutExerciseDTOs = workoutExerciseService.getLatestWorkoutExercisesDTOByWorkoutId(workoutId);

        if (workoutExerciseDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(workoutExerciseDTOs);
        }
    }


    @PostMapping("/getWorkoutExercise/{id}")
    public ResponseEntity<WorkoutExerciseDTO> getWorkoutExerciseById(@PathVariable("id") long id) {
        WorkoutExercise workoutExercise = workoutExerciseService.getWorkoutExerciseById(id);
        if (workoutExercise != null) {
            WorkoutExerciseDTO workoutExerciseDTO = new WorkoutExerciseDTO();
            workoutExerciseDTO.setId(workoutExercise.getId());
            workoutExerciseDTO.setExercise_id(workoutExercise.getExercise().getId());
            workoutExerciseDTO.setWorkout_id(workoutExercise.getWorkout().getId());
            workoutExerciseDTO.setSets(workoutExercise.getSets());
            workoutExerciseDTO.setReps(workoutExercise.getReps());

            return ResponseEntity.ok(workoutExerciseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

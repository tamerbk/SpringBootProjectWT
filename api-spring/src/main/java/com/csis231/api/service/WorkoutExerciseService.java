package com.csis231.api.service;


import com.csis231.api.model.Exercise;
import com.csis231.api.model.WorkoutExercise;
import com.csis231.api.model.WorkoutExerciseDTO;
import com.csis231.api.model.workout;
import com.csis231.api.repository.ExerciseRepository;
import com.csis231.api.repository.WorkoutExerciseRepository;
import com.csis231.api.repository.workoutRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutExerciseService {

    @Autowired
    private WorkoutExerciseRepository workoutExerciseRepository;
  @Autowired
    private workoutRepository workoutRepository;
    private  ExerciseRepository exerciseRepository;



    public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository,
                                  workoutRepository workoutRepository,
                                  ExerciseRepository exerciseRepository) {
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;

    }

    public WorkoutExercise createWorkoutExercise(WorkoutExercise workoutExercise) {
        return workoutExerciseRepository.save(workoutExercise);
    }


    public Long getMaxId(){
        return workoutExerciseRepository.getMaxId();
    }

    public List<Long> findWorkoutExercisesByWorkoutId(Long workoutId)
    {List<Long> workoutExercises = workoutExerciseRepository.findByWorkoutId(workoutId);


            return workoutExercises;

    }
    public List<WorkoutExerciseDTO> getLatestWorkoutExercisesDTOByWorkoutId(long workoutId) {

        List<WorkoutExercise> workoutExercises = workoutExerciseRepository.findLatestWorkoutExercisesByWorkoutId(workoutId);


        List<WorkoutExerciseDTO> workoutExerciseDTOs = workoutExercises.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return workoutExerciseDTOs;
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

    public WorkoutExercise getWorkoutExerciseById(long id) {
        WorkoutExercise workoutExercise = workoutExerciseRepository.getWorkoutExerciseById(id);
        return workoutExercise;
    }


    public WorkoutExercise save(WorkoutExercise workoutExercise) {
        return workoutExerciseRepository.save(workoutExercise);
    }
}

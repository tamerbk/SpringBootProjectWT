package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Exercise;

import com.csis231.api.model.workout;
import com.csis231.api.repository.ExerciseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;



    public List<Exercise> getExercisesByClientId(long id)
    {
        return exerciseRepository.findByClientId(id);
    }
    public Exercise getExerciseById(Long id){
        return exerciseRepository.getExerciseById(id);
    }
    public Exercise createExercise(Exercise exercise){return exerciseRepository.save(exercise);}

    public  List<Exercise> getExercisesByIds(List<Long> ids){
        return exerciseRepository.findDistinctByIdIn(ids);
    }
    public Map<String, Boolean> deleteExercise(Long id) {
        Exercise w = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found."));

        exerciseRepository.delete(w);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;

    }
}

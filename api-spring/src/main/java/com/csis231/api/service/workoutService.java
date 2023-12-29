package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.workout;
import com.csis231.api.repository.workoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class workoutService {

    @Autowired
    private workoutRepository workoutRepository;

    public List<workout> getWorkoutsByClientId(long id)
    {
        return workoutRepository.findByClient_id(id);
    }
    public workout createWorkout(workout workout){return workoutRepository.save(workout);}


    public Map<String, Boolean> deleteworkout(Long id) {
        workout w = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("workout not found."));

        workoutRepository.delete(w);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;

    }
      public workout getWorkoutById(Long id){
        return workoutRepository.getWorkoutById( id);
      }

}

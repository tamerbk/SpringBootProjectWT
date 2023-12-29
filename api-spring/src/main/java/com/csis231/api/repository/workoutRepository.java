package com.csis231.api.repository;

import com.csis231.api.model.workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface workoutRepository extends JpaRepository<workout, Long> {

    List<workout> findByClient_id(long id);
    workout getWorkoutById(Long id);
}

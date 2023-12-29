package com.csis231.api.repository;


import com.csis231.api.model.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByClientId(long id);
    List<Exercise> findDistinctByIdIn(List<Long> ids);

    Exercise getExerciseById(Long id);
}

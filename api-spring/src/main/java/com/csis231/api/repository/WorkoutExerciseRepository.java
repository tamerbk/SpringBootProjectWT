package com.csis231.api.repository;



import com.csis231.api.model.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {

   WorkoutExercise getWorkoutExerciseById(long id);


  @Query(value = "SELECT DISTINCT exercise_id FROM workout_exercise  WHERE workout_id = :workoutId", nativeQuery = true)
  List<Long> findByWorkoutId(@Param("workoutId") Long workout_id);
    @Query(value = "SELECT Max(id) FROM workout_exercise  ", nativeQuery = true)
    Long getMaxId();
    @Query(value ="SELECT * FROM Workout_Exercise  WHERE workout_id = :workoutId AND date = (SELECT MAX(date) FROM Workout_Exercise  WHERE workout_id = :workoutId)", nativeQuery = true)
    List<WorkoutExercise> findLatestWorkoutExercisesByWorkoutId(@Param("workoutId") long workoutId);


}

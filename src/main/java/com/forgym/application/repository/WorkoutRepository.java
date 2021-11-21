package com.forgym.application.repository;

import com.forgym.application.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
}

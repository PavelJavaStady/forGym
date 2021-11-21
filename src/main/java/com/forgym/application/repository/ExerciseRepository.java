package com.forgym.application.repository;

import com.forgym.application.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
}

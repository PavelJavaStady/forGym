package com.forgym.application.controller;

import com.forgym.application.model.Trainer;
import com.forgym.application.model.Workout;
import com.forgym.application.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorkoutController {
    private WorkoutRepository workoutRepository;

@Autowired
    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }
    @GetMapping("/workouts")
    public String allWorkouts(Model model) {
        List<Workout> workoutList = workoutRepository.findAll();
        model.addAttribute("workoutList", workoutList);
        return "workouts";
    }
}

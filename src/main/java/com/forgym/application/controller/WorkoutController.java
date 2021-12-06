package com.forgym.application.controller;

import com.forgym.application.model.*;
import com.forgym.application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkoutController {

    private WorkoutRepository workoutRepository;
    private ExerciseRepository exerciseRepository;
    private ClientRepository clientRepository;
    private ResultWorkoutsRepository resultWorkoutsRepository;

    @Autowired
    public WorkoutController(WorkoutRepository workoutRepository,
                             ExerciseRepository exerciseRepository,
                             ClientRepository clientRepository,
                             ResultWorkoutsRepository resultWorkoutsRepository) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.clientRepository = clientRepository;
        this.resultWorkoutsRepository = resultWorkoutsRepository;

    }

    @GetMapping("/workouts/new/{id}")
    public String showCreateNewWorkoutForm(@PathVariable("id") Integer id, Model model) {
        Client client = clientRepository.findById(id).get();
        List<Exercise> exerciseList = exerciseRepository.findAll();
        model.addAttribute("exerciseList", exerciseList);
        model.addAttribute("workout", new Workout());
        model.addAttribute("client", client);
        return "workout-form";
    }

    @PostMapping("workouts/save")
    public String workoutSave(Workout workout) {
        workoutRepository.save(workout);
        return "redirect:/trainer";
    }

    @GetMapping("/results/new/{id}")
    public String showResultForm(@PathVariable("id") Integer id, Model model) {
        Workout workout = workoutRepository.findById(id).get();
        model.addAttribute("resultWorkouts", new ResultWorkouts());
        model.addAttribute("workout", workout);
        return "results-form";
    }

    @PostMapping("resultWorkouts/save")
    public String resultWorkoutsSave(@ModelAttribute Workout workout, ResultWorkouts resultWorkouts) {
        workout.setResultWorkouts(resultWorkouts);
        resultWorkoutsRepository.save(resultWorkouts);
        return "redirect:/client";
    }

    @GetMapping("/results/{id}")
    public String showResults(@PathVariable("id") Integer id, Model model) {
        Workout workout = workoutRepository.findById(id).get();
        ResultWorkouts resultWorkouts = workout.getResultWorkouts();
        model.addAttribute("resultWorkouts", resultWorkouts);
        return "results";
    }
}
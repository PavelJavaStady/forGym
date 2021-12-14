package com.forgym.application.controller;

import com.forgym.application.model.Client;
import com.forgym.application.model.Trainer;
import com.forgym.application.model.Workout;
import com.forgym.application.repository.ClientRepository;
import com.forgym.application.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TrainerController {
    private TrainerRepository trainerRepository;
    private ClientRepository clientRepository;

    @Autowired
    public TrainerController(TrainerRepository trainerRepository, ClientRepository clientRepository) {
        this.trainerRepository = trainerRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/trainers")
    public String allTrainers(Model model) {
        List<Trainer> trainerList = trainerRepository.findAll();
        model.addAttribute("trainerList", trainerList);
        return "trainers";
    }

    @GetMapping("trainers/new")
    public String showCreateNewTrainerForm(Model model) {
        List<Client> clientsList = clientRepository.findAll();
        model.addAttribute("clientsList", clientsList);
        model.addAttribute("trainer", new Trainer());
        return "trainer-form";
    }

    @PostMapping("trainers/save")
    public String trainerSave(Trainer trainer) {
        trainerRepository.save(trainer);
        return "redirect:/trainers";
    }

    @GetMapping("/trainers/edit/{id}")
    public String showEditTrainerForm(@PathVariable("id") Integer id, Model model) {
        Trainer trainer = trainerRepository.findById(id).get();
        model.addAttribute("trainer", trainer);
        return "trainer-form";
    }

    @GetMapping("/trainers/delete/{id}")
    public String deleteTrainer(@PathVariable("id") Integer id, Model model) {
        trainerRepository.deleteById(id);
        return "redirect:/trainers";
    }

    @GetMapping("/trainer")
    public String showFormForTrainer(Model model) {
        model.addAttribute("trainer", new Trainer());
        return "trainer";
    }

    @PostMapping("/trainer")
    public String showClientsForTrainer(@ModelAttribute Trainer trainer, Model model) {
        Trainer trainer1 = trainerRepository.findByFirstNameAndLastName(trainer.getFirstName(), trainer.getLastName());
        List<Client> clientList = trainer1.getClients();
        model.addAttribute("clientList", clientList);
        model.addAttribute("trainer", trainer1);
        return "clients for trainer";
    }

    @GetMapping("/trainer/workouts/{id}")
    public String showWorcoutsForClient(@PathVariable("id") Integer id, Model model) {
        Client client = clientRepository.findById(id).get();
        List<Workout> workoutList = client.getWorkoutList();
        model.addAttribute("workoutList", workoutList);
        return "workouts";
    }
}
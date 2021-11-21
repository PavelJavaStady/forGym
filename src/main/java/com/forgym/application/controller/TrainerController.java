package com.forgym.application.controller;

import com.forgym.application.model.Client;
import com.forgym.application.model.Trainer;
import com.forgym.application.repository.ClientRepository;
import com.forgym.application.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("trainers/edit/{id}")
    public String showEditClientForm (@PathVariable("id") Integer id, Model model){
        Trainer trainer = trainerRepository.findById(id).get();
        model.addAttribute("trainer", trainer);
        return "trainer-form";
    }

    @GetMapping("trainers/delete/{id}")
    public String deleteProduct (@PathVariable("id") Integer id, Model model){
        trainerRepository.deleteById(id);
        return "redirect:/trainers";
    }
}
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
public class ClientController {
private ClientRepository clientRepository;
private TrainerRepository trainerRepository;

@Autowired
    public ClientController(ClientRepository clientRepository, TrainerRepository trainerRepository) {
        this.clientRepository = clientRepository;
        this.trainerRepository = trainerRepository;
    }

    @GetMapping("/clients")
    public String allClients(Model model) {
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clientList", clientList);
        return "clients";
    }
    @GetMapping("clients/new")
    public String showCreateNewClientForm(Model model) {
        model.addAttribute("client", new Client());
        List<Trainer> trainerList = trainerRepository.findAll();
        model.addAttribute("trainerList", trainerList);
        return "client-form";
    }
    @PostMapping("clients/save")
    public String clientSave(Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }
    @GetMapping("clients/edit/{id}")
    public String showEditClientForm (@PathVariable("id") Integer id, Model model){
        Client client = clientRepository.findById(id).get();
        model.addAttribute("client", client);
        List<Trainer> trainerList = trainerRepository.findAll();
        model.addAttribute("trainerList", trainerList);
        return "client-form";
    }

    @GetMapping("clients/delete/{id}")
    public String deleteProduct (@PathVariable("id") Integer id, Model model){
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}
package com.forgym.application.repository;

import com.forgym.application.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
     Trainer findByFirstNameAndLastName(String firstName,String lastName);
}

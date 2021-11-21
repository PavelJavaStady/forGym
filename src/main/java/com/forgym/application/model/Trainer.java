package com.forgym.application.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45,nullable = false)
    private String firstName;
    @Column(length = 45,nullable = false)
    private String lastName;
    @Column(length = 3,nullable = false)
    private int age;
    @Column(length = 5,nullable = false)
    private String sex;
    @Column(length = 9,nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private List<Client> clients;


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    }


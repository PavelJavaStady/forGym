package com.forgym.application.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Client {
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

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Workout> workoutList = new ArrayList<>();


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

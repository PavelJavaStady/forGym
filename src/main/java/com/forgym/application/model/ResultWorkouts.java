package com.forgym.application.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ResultWorkouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3, nullable = false)
    private int weightClients;
    @Column(length = 1000, nullable = false)
    private String results;

    @OneToOne(mappedBy = "resultWorkouts", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Workout workout;
}

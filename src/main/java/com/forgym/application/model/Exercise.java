package com.forgym.application.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255,nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Override
    public String toString() {
        return title;
    }
}

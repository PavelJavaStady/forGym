package com.forgym.application.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @Column(length = 1000,nullable = false)
    private String explanations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private List<Exercise>exercises;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resultworkouts_id")
    private ResultWorkouts resultWorkouts;

    @Override
    public String toString() {
        return "Workout{" +
                "date=" + date +
                '}';
    }
}

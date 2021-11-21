package com.forgym.application.model;

import lombok.Data;

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
    private Date date;
    @Column(length = 1000, nullable = false)
    private String exercises;
    @Column(length = 1000,nullable = false)
    private String explanations;

}

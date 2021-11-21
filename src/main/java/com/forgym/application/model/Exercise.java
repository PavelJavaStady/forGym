package com.forgym.application.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45,nullable = false)
    private String title;

}

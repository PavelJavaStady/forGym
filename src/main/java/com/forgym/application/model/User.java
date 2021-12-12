package com.forgym.application.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(length = 64, nullable = false)
    private String password;
    @Column(length = 45,nullable = false)
    private String userName;
    @Column(length = 10, nullable = false)
    private String role;
}

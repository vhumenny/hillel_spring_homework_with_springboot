package com.hillel.spring.hillel_spring_homework_with_springboot.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String name;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}

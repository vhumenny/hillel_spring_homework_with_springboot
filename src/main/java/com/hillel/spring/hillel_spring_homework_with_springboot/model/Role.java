package com.hillel.spring.hillel_spring_homework_with_springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}

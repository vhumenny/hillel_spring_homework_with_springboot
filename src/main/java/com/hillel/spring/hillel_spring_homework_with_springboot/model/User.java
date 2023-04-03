package com.hillel.spring.hillel_spring_homework_with_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class User {
    @Id
    private Integer id;
    private String name;
    private String password;
    private Role role;



   enum Role {

   }
}

package com.hillel.spring.hillel_spring_homework_with_springboot.repository;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByName(String name);
}

package com.hillel.spring.hillel_spring_homework_with_springboot.repository;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
            SELECT u FROM User u WHERE u.username = :username
            """)
    Optional<User> findUsersByUsername(String username);
}

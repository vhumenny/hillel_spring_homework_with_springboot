package com.hillel.spring.hillel_spring_homework_with_springboot.repository;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

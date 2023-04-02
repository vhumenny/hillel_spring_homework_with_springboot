package com.hillel.spring.hillel_spring_homework_with_springboot.repository;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}

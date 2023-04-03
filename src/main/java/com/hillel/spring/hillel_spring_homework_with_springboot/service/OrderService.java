package com.hillel.spring.hillel_spring_homework_with_springboot.service;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public Order saveOrder(Order order);

    public Order getOrder(int id);
}

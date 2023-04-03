package com.hillel.spring.hillel_spring_homework_with_springboot.controller;


import com.hillel.spring.hillel_spring_homework_with_springboot.model.Order;
import com.hillel.spring.hillel_spring_homework_with_springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> showAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order showOrderById(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    public Order addNewOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "Order with id = " + id + " was deleted";
    }
}

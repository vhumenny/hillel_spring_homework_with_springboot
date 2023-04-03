package com.hillel.spring.hillel_spring_homework_with_springboot.service;

import com.hillel.spring.hillel_spring_homework_with_springboot.exception.NoSuchOrderException;
import com.hillel.spring.hillel_spring_homework_with_springboot.model.Order;
import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;
import com.hillel.spring.hillel_spring_homework_with_springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        order.setDate(LocalDateTime.now());
        order.setCost(getOrderCost(order.getProducts()));

        orderRepository.save(order);
        return order;
    }

    private BigDecimal getOrderCost(List<Product> productList) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Product product : productList) {
            totalCost = totalCost.add(product.getCost());
        }
        return totalCost;
    }

    @Override
    public Order getOrder(Integer id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NoSuchOrderException("There is no order with ID = " + id + " in Database.");
        }
        return optional.get();
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}

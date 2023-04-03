package com.hillel.spring.hillel_spring_homework_with_springboot.controller;


import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;
import com.hillel.spring.hillel_spring_homework_with_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class OrderController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> showAllOrders() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product showOrderById(@PathVariable int id) {
        return productService.getProduct(id);
    }
}

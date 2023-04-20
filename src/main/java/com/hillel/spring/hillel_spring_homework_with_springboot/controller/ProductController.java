package com.hillel.spring.hillel_spring_homework_with_springboot.controller;


import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;
import com.hillel.spring.hillel_spring_homework_with_springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<Product> showAllOrders() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product showOrderById(@PathVariable Integer id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "Product with id = " + id + " was deleted from DB";
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
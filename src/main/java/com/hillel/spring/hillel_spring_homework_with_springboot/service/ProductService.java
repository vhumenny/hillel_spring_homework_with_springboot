package com.hillel.spring.hillel_spring_homework_with_springboot.service;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product saveProduct(Product product);

    Product findProductById(Integer id);

    void deleteProduct(Integer id);
}

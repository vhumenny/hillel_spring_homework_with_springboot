package com.hillel.spring.hillel_spring_homework_with_springboot.service;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();

    public Product saveProduct(Product product);

    public Product findProductById(Integer id);

    public void deleteProduct(Integer id);
}

package com.hillel.spring.hillel_spring_homework_with_springboot.service;

import com.hillel.spring.hillel_spring_homework_with_springboot.exception.NoSuchProductException;
import com.hillel.spring.hillel_spring_homework_with_springboot.model.Product;
import com.hillel.spring.hillel_spring_homework_with_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NoSuchProductException("There is no product with ID = " + id + " in Database.");
        }
        return optional.get();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


}

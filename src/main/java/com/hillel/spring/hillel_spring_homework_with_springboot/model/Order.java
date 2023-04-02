package com.hillel.spring.hillel_spring_homework_with_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private LocalDate date;
    private BigDecimal cost;
    private List<Product> products;
}

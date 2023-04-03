package com.hillel.spring.hillel_spring_homework_with_springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer id;
    private String name;
    private BigDecimal cost;
}

package com.hillel.spring.hillel_spring_homework_with_springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    private LocalDateTime date;
    private BigDecimal cost;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name= "order_id")
    private List<Product> products;
}

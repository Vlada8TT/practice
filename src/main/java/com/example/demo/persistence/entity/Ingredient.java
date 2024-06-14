package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20,
    nullable = false)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Product> products;

}

package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    @Column(nullable = false)
    private String street;

    @Column(length = 10, nullable = false)
    private String house_number;

    @Column(length = 10)
    private String apartment_number;


}

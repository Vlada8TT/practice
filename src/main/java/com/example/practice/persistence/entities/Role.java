package com.example.practice.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String name;

}

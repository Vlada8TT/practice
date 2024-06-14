package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class Order {
    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private Integer user_id;
    @Setter
    @Getter
    private Timestamp time;
    @Setter
    @Getter
    private String status;



}

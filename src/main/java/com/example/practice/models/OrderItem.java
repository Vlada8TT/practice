package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

public class OrderItem {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer user_id;
    @Getter
    @Setter
    private Integer product_id;
    @Getter
    @Setter
    private Integer quantity;
}

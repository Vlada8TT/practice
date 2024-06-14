package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer category_id;
    @Getter
    @Setter
    private Integer image_id;
    @Getter
    @Setter
    private Integer price;
    @Getter
    @Setter
    private String name;

}

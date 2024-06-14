package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

public class Address {
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String apartment_number;

    @Setter
    @Getter
    private String house_number;

    @Setter
    @Getter
    private String city;

    @Setter
    @Getter
    private String street;

}

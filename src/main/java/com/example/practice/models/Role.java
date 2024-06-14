package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class Role {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @NotEmpty
    private String name;


}
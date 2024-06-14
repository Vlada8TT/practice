package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class Image {

    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    @NotEmpty
    private String path;

}
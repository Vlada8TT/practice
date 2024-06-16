package com.example.demo.dto;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class ImageDto {
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "Path must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 64, message = "Path length must be shorter than 65", groups = {OnCreate.class, OnUpdate.class})
    private String path;
}

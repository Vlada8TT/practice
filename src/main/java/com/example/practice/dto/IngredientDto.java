package com.example.practice.dto;

import com.example.practice.dto.validation.OnCreate;
import com.example.practice.dto.validation.OnUpdate;
import lombok.Data;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class IngredientDto {
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Name length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String name;
}

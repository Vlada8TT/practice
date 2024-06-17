package com.example.demo.dto.requests;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;

@Data
public class RoleRequestDto {
    @NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Name length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String name;
}





package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;


public record RoleRequestDto(
        @NotNull(message = "{name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{name.length}", groups = {OnCreate.class, OnUpdate.class})
        String name
) {
}






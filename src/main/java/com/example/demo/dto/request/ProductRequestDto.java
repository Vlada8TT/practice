package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;

public record ProductRequestDto(
        @NotNull(message = "{name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{name.length}", groups = {OnCreate.class, OnUpdate.class})
        String name,

        @NotNull(message = "{price.notnull}", groups = {OnCreate.class, OnUpdate.class})
        BigDecimal price,

        @NotNull(message = "{category.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{category.length}", groups = {OnCreate.class, OnUpdate.class})
        CategoryRequestDto category,

        String imagePath

) {
}
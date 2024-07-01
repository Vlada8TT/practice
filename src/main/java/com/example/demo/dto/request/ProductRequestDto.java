package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;

@Schema(description = "Product request DTO")
public record ProductRequestDto(
        @Schema(description = "Product name", example = "Cola")
        @NotNull(message = "{name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{name.length}", groups = {OnCreate.class, OnUpdate.class})
        String name,

        @Schema(description = "Product price", example = "3.99")
        @NotNull(message = "{price.notnull}", groups = {OnCreate.class, OnUpdate.class})
        BigDecimal price,

        @Schema(description = "Product category")
        @NotNull(message = "{category.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{category.length}", groups = {OnCreate.class, OnUpdate.class})
        CategoryRequestDto category,

        @Schema(description = "Product image path")
        String imagePath

) {
}
package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Category request DTO")
public record CategoryRequestDto(
        @Schema(description = "Category name", example = "drink")
        @NotNull(message = "{name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{name.length}", groups = {OnCreate.class, OnUpdate.class})
        String name
) {
}
package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Address request DTO")
public record AddressRequestDto(
        @Schema(description = "Apartment number", example = "12")
        @NotNull(message = "{apartment_number.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{apartment_number.length}", groups = {OnCreate.class, OnUpdate.class})
        String apartment_number,

        @Schema(description = "House number", example = "88")
        @NotNull(message = "{house_number.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{house_number.length}", groups = {OnCreate.class, OnUpdate.class})
        String house_number,

        @Schema(description = "City name", example = "Minsk")
        @NotNull(message = "{city.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{city.length}", groups = {OnCreate.class, OnUpdate.class})
        String city,

        @Schema(description = "Street name", example = "Rafieva")
        @NotNull(message = "{street.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{street.length}", groups = {OnCreate.class, OnUpdate.class})
        String street
) {
}
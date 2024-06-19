package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AddressRequestDto(
        @NotNull(message = "{apartment_number.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{apartment_number.length}", groups = {OnCreate.class, OnUpdate.class})
        String apartmentNumber,

        @NotNull(message = "{house_number.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{house_number.length}", groups = {OnCreate.class, OnUpdate.class})
        String houseNumber,

        @NotNull(message = "{city.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{city.length}", groups = {OnCreate.class, OnUpdate.class})
        String city,

        @NotNull(message = "{street.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{street.length}", groups = {OnCreate.class, OnUpdate.class})
        String street
) {
}
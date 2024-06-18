package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ImageRequestDto(
        @NotNull(message = "{path.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 64, message = "{path.length}", groups = {OnCreate.class, OnUpdate.class})
        String path
) {
}

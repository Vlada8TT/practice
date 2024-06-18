package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public record OrderRequestDto(
        @NotNull(message = "{user_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{user_id.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer user_id,

        @NotNull(message = "{time.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        LocalDateTime time,

        @NotNull(message = "{status.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{status.length}", groups = {OnCreate.class, OnUpdate.class})
        String status
) {
}
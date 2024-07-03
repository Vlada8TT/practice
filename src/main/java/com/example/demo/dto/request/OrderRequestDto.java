package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public record OrderRequestDto(
        @NotNull(message = "{user_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer userId,

        @NotNull(message = "{time.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Timestamp orderDate,

        @NotNull(message = "{status.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{status.length}", groups = {OnCreate.class, OnUpdate.class})
        String status
) {
}
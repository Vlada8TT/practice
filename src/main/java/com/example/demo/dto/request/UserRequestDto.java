package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record UserRequestDto(
        @NotNull(message = "{name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{name.length}", groups = {OnCreate.class, OnUpdate.class})
        String name,

        @NotNull(message = "{mobilePhone.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{mobilePhone.length}", groups = {OnCreate.class, OnUpdate.class})
        String mobilePhone,

        @NotNull(message = "{email.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 32, message = "{email.length}", groups = {OnCreate.class, OnUpdate.class})
        String email,

        @NotNull(message = "{password.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 32, message = "{password.length}", groups = {OnCreate.class, OnUpdate.class})
        String password
) {
}
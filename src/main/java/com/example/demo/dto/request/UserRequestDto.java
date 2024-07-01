package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Schema(description = "User request DTO")
public record UserRequestDto(
        @Schema(description = "User name", example = "Stas")
        @NotNull(message = "{name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{name.length}", groups = {OnCreate.class, OnUpdate.class})
        String name,

        @Schema(description = "User mobile phone", example = "+375292887312")
        @NotNull(message = "{mobilePhone.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{mobilePhone.length}", groups = {OnCreate.class, OnUpdate.class})
        String mobilePhone,

        @Schema(description = "User email", example = "stas@gmail.com")
        @NotNull(message = "{email.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 32, message = "{email.length}", groups = {OnCreate.class, OnUpdate.class})
        String email,

        @Schema(description = "User password", example = "12345")
        @NotNull(message = "{password.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 32, message = "{password.length}", groups = {OnCreate.class, OnUpdate.class})
        String password,

        @Schema(description = "User address")
        @NotNull(message = "{address.notnull}", groups = {OnCreate.class, OnUpdate.class})
        AddressRequestDto address,

        @Schema(description = "User role")
        @NotNull(message = "{role.notnull}", groups = {OnCreate.class, OnUpdate.class})
        RoleRequestDto role
) {
}
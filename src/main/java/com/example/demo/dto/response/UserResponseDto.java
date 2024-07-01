package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User response DTO")
public record UserResponseDto(
        Integer id,

        @Schema(description = "User name", example = "Stas")
        String name,

        @Schema(description = "User mobile phone", example = "+375292887312")
        String mobilePhone,

        @Schema(description = "User email", example = "stas@gmail.com")
        String email,

        @Schema(description = "User address")
        AddressResponseDto address,

        @Schema(description = "User role")
        RoleResponseDto role
) {
}
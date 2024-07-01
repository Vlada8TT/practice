package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Role response DTO")
public record RoleResponseDto(
        @Schema(description = "Role id", example = "1")
        Integer id,

        @Schema(description = "Role name", example = "ROLE_USER")
        String name
) {
}
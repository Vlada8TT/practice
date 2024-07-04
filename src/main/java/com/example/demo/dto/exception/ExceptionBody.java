package com.example.demo.dto.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Exception body DTO")
@Builder
public record ExceptionBody(

        @Schema(description = "Status id", example = "404")
        Integer status,

        @Schema(description = "Exception message", example = "Not found")
        String message
) {
}
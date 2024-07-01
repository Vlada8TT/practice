package com.example.demo.dto.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.Map;

@Schema(description = "Multi exception body DTO")
@Builder
public record MultiExceptionBody(

        @Schema(description = "Status id", example = "400")
        Integer status,

        @Schema(description = "Exception message", example = "Bad Request")
        String message,

        @Schema(description = "Errors")
        Map<String, String> errors
) {
}

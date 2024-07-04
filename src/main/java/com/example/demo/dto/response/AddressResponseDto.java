package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Address response DTO")
public record AddressResponseDto(
        @Schema(description = "Address id", example = "1")
        Integer id,

        @Schema(description = "Apartment number", example = "12")
        String apartment_number,

        @Schema(description = "House number", example = "88")
        String house_number,

        @Schema(description = "City name", example = "Minsk")
        String city,

        @Schema(description = "Street name", example = "Rafieva")
        String street
) {
}
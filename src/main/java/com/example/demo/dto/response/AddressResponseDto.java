package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Address response DTO")
public record AddressResponseDto(
        @Schema(description = "Address id", example = "1")
        Integer id,

        @Schema(description = "Apartment number", example = "12")
        String apartmentNumber,

        @Schema(description = "House number", example = "88")
        String houseNumber,

        @Schema(description = "City name", example = "Minsk")
        String city,

        @Schema(description = "Street name", example = "Rafieva")
        String street
) {
}
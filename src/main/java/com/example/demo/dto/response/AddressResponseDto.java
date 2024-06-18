package com.example.demo.dto.response;

public record AddressResponseDto(
        Integer id,

        String apartment_number,

        String house_number,

        String city,

        String street
) {
}
package com.example.demo.dto.response;

public record AddressResponseDto(
        Integer id,

        String apartmentNumber,

        String houseNumber,

        String city,

        String street
) {
}
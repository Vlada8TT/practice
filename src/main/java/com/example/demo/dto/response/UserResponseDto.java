package com.example.demo.dto.response;

public record UserResponseDto(
        Integer id,

        String name,

        String mobilePhone,

        String email,

        AddressResponseDto address,

        RoleResponseDto role
) {
}